from flask import Flask, request, jsonify
from pymongo import MongoClient
from datetime import datetime

# Kết nối tới MongoDB
app = Flask(__name__)
client = MongoClient('mongodb://localhost:27017/Nguyendz')
db = client['medical_service_system']
patients_collection = db['patients']
doctors_collection = db['doctors']
appointments_collection = db['appointments']

# Hiển thị thông tin khi app bắt đầu
@app.route('/')
def index():
    return '''
    <h1>Chào mừng bạn đến với Hệ thống Y tế!</h1>
    <h2>API hiện có:</h2>
    <ul>
        <li>1. Thêm Bệnh Nhân: POST /add_patients</li>
        <li>2. Thêm Bác Sĩ: POST /add_doctors</li>
        <li>3. Thêm Cuộc Hẹn: POST /add_appointments</li>
        <li>4. Tạo Báo Cáo: GET /generate_report</li>
        <li>5. Lấy Các Cuộc Hẹn Hôm Nay: GET /appointments_today</li>
    </ul>
    '''

# Các route khác của bạn tiếp tục dưới đây
# Route thêm bệnh nhân từ bàn phím
@app.route('/add_patients', methods=['POST'])
def add_patients():
    patients = []
    for i in range(3):
        name = input(f"Enter name for patient {i+1}: ")
        birthday = input(f"Enter birthday for patient {i+1}: ")
        gender = input(f"Enter gender for patient {i+1}: ")
        address = input(f"Enter address for patient {i+1}: ")
        doctor_name = input(f"Enter doctor name for patient {i+1}: ")
        patients.append({
            "name": name,
            "birthday": birthday,
            "gender": gender,
            "address": address,
            "doctor_name": doctor_name
        })
    patients_collection.insert_many(patients)
    return jsonify({"message": "Patients added successfully"}), 201

# Route thêm bác sĩ từ bàn phím
@app.route('/add_doctors', methods=['POST'])
def add_doctors():
    doctors = []
    for i in range(5):
        name = input(f"Enter name for doctor {i+1}: ")
        specialty = input(f"Enter specialty for doctor {i+1}: ")
        doctors.append({
            "name": name,
            "specialty": specialty
        })
    doctors_collection.insert_many(doctors)
    return jsonify({"message": "Doctors added successfully"}), 201

# Route thêm cuộc hẹn
@app.route('/add_appointments', methods=['POST'])
def add_appointments():
    appointments = []
    for i in range(3):
        patient_name = input(f"Enter patient name for appointment {i+1}: ")
        doctor_name = input(f"Enter doctor name for appointment {i+1}: ")
        date = input(f"Enter date (YYYY-MM-DD) for appointment {i+1}: ")
        status = input(f"Enter status for appointment {i+1} (e.g. Pending/Done): ")
        note = input(f"Enter note for appointment {i+1}: ")
        appointments.append({
            "patient_name": patient_name,
            "doctor_name": doctor_name,
            "date": date,
            "status": status,
            "note": note
        })
    appointments_collection.insert_many(appointments)
    return jsonify({"message": "Appointments added successfully"}), 201

# Route tạo báo cáo và hiển thị nó
@app.route('/generate_report', methods=['GET'])
def generate_report():
    report = []
    patients = patients_collection.find()
    appointments = appointments_collection.find()
    
    for patient in patients:
        patient_appointments = list(filter(lambda a: a["patient_name"] == patient["name"], appointments))
        for appointment in patient_appointments:
            report.append({
                "No": patient["_id"],
                "Patient name": patient["name"],
                "Birthday": patient["birthday"],
                "Gender": patient["gender"],
                "Address": patient["address"],
                "Doctor name": appointment["doctor_name"],
                "Reason": appointment["note"],
                "Date": appointment["date"]
            })
    
    # Hiển thị báo cáo theo yêu cầu
    for row in report:
        print(f"No: {row['No']} Patient name: {row['Patient name']} Birthday: {row['Birthday']} Gender: {row['Gender']} "
              f"Address: {row['Address']} Doctor name: {row['Doctor name']} Reason: {row['Reason']} Date: {row['Date']}")
    
    return jsonify(report), 200

# Route lấy các cuộc hẹn hôm nay và hiển thị
@app.route('/appointments_today', methods=['GET'])
def appointments_today():
    today = datetime.today().strftime('%Y-%m-%d')
    appointments_today = appointments_collection.find({"date": today})
    
    appointments_list = []
    for appointment in appointments_today:
        patient = patients_collection.find_one({"name": appointment["patient_name"]})
        appointments_list.append({
            "Address": patient["address"],
            "No": patient["_id"],
            "Patient name": patient["name"],
            "Birthday": patient["birthday"],
            "Gender": patient["gender"],
            "Doctor name": appointment["doctor_name"],
            "Status": appointment["status"],
            "Note": appointment["note"]
        })
    
    # Hiển thị các cuộc hẹn hôm nay
    for row in appointments_list:
        print(f"Address: {row['Address']} No: {row['No']} Patient name: {row['Patient name']} "
              f"Birthday: {row['Birthday']} Gender: {row['Gender']} Doctor name: {row['Doctor name']} "
              f"Status: {row['Status']} Note: {row['Note']}")
    
    return jsonify(appointments_list), 200

# Chạy Flask app
if __name__ == '__main__':
    app.run(debug=True)
