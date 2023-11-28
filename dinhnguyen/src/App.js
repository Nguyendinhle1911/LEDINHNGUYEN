import React from "react";

export default function Book() {
  return (
    <div>
      <meta charSet="UTF-8" />
      <title>AngularJS Practical Examples</title>
      <link
        rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
      />
      <div className="container">
        <div className="input-group">
          <span className="input-group-addon">
            <span className="glyphicon glyphicon-search" />
          </span>
          <input
            type="text"
            className="form-control"
            ng-model="main.searchInput"
          />
        </div>
        <h3>A list of Books</h3>
        <ul className="list-group">
          <li
            className="list-group-item"
            ng-repeat="show in main.shows | filter:main.searchInput | orderBy:main.order.key:main.order.reverse"
          >
            <span className="glyphicon glyphicon-star" ng-if="show.favorite" />{" "}
            <span className="badge">
              {"{"}
              {"{"}show.author{"}"}
              {"}"}
            </span>
          </li>
        </ul>
        <select
          className="form-control pull-right"
          ng-model="main.order"
          ng-options="order as order.title for order in main.orders"
        />
        <div className="clearfix" />
        <h3>Add a new Book</h3>
        <form name="main.addForm" className="form" ng-submit="main.addShow()">
          <div className="form-group">
            <label>Title</label>
            <input
              type="text"
              className="form-control"
              ng-model="main.new.title"
              required
            />
          </div>
          <div className="form-group">
            <label>Author</label>
            <input
              type="text"
              className="form-control"
              ng-model="main.new.author"
              required
            />
            {/*<input type="number" min="1900" max="2030" class="form-control" ng-model="main.new.year" required />*/}
          </div>
          <div className="row">
            <div className="col-xs-6">
              <label>
                Favorite: <input type="checkbox" ng-model="main.new.favorite" />
              </label>
            </div>
            <div className="col-xs-6">
              <button className="btn btn-success pull-right">
                <span className="glyphicon glyphicon-plus-sign" /> Add
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  );
}