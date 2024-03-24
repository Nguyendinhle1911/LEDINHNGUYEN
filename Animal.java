package session3;
// khai bao lop
// lop nay có the chưa 1 hoặc nhieu phuong thuc abstract
//cho phép
public abstract class Animal {
    private String name;
    public Animal(){
        //gan gia tri mac dinh cho name
        // this.name = "Tom";
        this.name = this.getAnimalName();
    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // abstract: day la lop "truu tuong" -> co the duoc "sua" o lop con
    //lop con dinh nghia lai hanh vi maf no muon
    //the hien tinh chat da hinh
    // khong chua ma (code) ben trong
    //no  phai thuoc ve mot lop Abstract
    public abstract String getAnimalName();
}
