<%--
  Created by IntelliJ IDEA.
  User: vindu
  Date: 17.06.2018
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<html ng-app="myapp">
<head>
    <meta charset="utf-8">
    <title>ToDo App</title>
    <style>
        .status{text-decoration: line-through;color:#ccc;}
    </style>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>
    <script type="text/javascript">
        var app = angular.module('myapp', []).controller('todoController', function($scope, $http) {
            $http.get('/tasks').
            then(function(response) {
                $scope.todos = response.data;
            });
            $scope.unfinishedTasks = function(){
                $http.get('/tasks/filter/completed').
                then(function(response) {
                    $scope.todos = response.data;
                });
            };

            $scope.allTasks = function(){
                $http.get('/tasks').
                then(function(response) {
                    $scope.todos = response.data;
                });
            };
            $scope.finishedTasks = function(){
                $http.get('/tasks/filter/uncompleted').
                then(function(response) {
                    $scope.todos = response.data;
                });
            };
            $scope.postData = function(name){
                var data = { "name": name, "status": false };
                $http.post(
                    '/tasks',
                    JSON.stringify(data),
                    {
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }
                ).success(function () {
                    $scope.allTasks();
                    $scope.name = '';
                });
            };
            $scope.finishTask = function(id){
                $http.post('/tasks/complete/' + id).
                success(function() {
                    $scope.allTasks();
                });
            };

            $scope.editData = function(name,id){
                $http.post('/tasks/' + id + '/' + name).
                success(function() {
                    $scope.allTasks();
                });
            };
            $scope.deleteData = function(id){
                $http.delete('/tasks/' + id).
                success(function() {
                    $scope.allTasks();
                });
            }


        });
    </script>

</head>

<body>
<script type="text/javascript" src="js/myapp.js"></script>
<div ng-controller="todoController">
    <form name="frm" ng-submit="postData(name)">
        <input type="text" name="newTodo" ng-model="name" required/>
        <button ng-disabled="frm.$invalid">Add</button>
    </form>
    <button ng-click="unfinishedTasks()">Unfinished Tasks</button>
    <button ng-click="allTasks()">All Tasks</button>
    <button ng-click="finishedTasks()">Finished Tasks</button>
        <ul>
        <li ng-repeat="todo in todos">
            <input type="checkbox" ng-model="todo.status" ng-change="finishTask(todo.id)"/>
            <input type="text" name="editTodo" ng-class="{'status':todo.status}" ng-model="todo.name" required/>
            <button ng-click="editData(todo.name,todo.id)">Edit</button>
            <button ng-click="deleteData(todo.id)">Delete</button>
        </li>
    </ul>
</div>
</body>
</html>
