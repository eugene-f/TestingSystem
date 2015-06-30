<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--<!DOCTYPE html>-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>

    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet"
          href="https://ajax.googleapis.com/ajax/libs/angular_material/0.10.0/angular-material.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular-aria.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angular_material/0.10.0/angular-material.min.js"></script>
    <script src="app.js"></script>

</head>
<body>

<div ng-app="app">
    <div layout="column" layout-fill>
        <md-toolbar>
            <div class="md-toolbar-tools">
                <md-button class="md-icon-button" aria-label="Menu">
                    <md-icon>menu</md-icon>
                    <md-tooltip>Меню</md-tooltip>
                </md-button>
                <span>Система тестирования</span>
                <span flex></span>
                <md-button>Регистрация</md-button>
                <md-button>Вход</md-button>
                <md-button class="md-icon-button" aria-label="Action">
                    <md-icon>more_vert</md-icon>
                    <md-tooltip>Действия</md-tooltip>
                </md-button>
            </div>
        </md-toolbar>
        <md-content>
            <md-card>
                <md-card-content>
                    <h2 class="md-title">Регистрация</h2>

                    <p>Для регистрации Вам необходимо заполнить все поля</p>

                    <form name="userForm" method="post" action="/registration">
                        <md-input-container class="md-icon-float" flex>
                            <label>Имя</label>
                            <md-icon>account_circle</md-icon>
                            <input type="text" name="firstName">
                        </md-input-container>
                        <md-input-container class="md-icon-float" flex>
                            <label>Фамилия</label>
                            <md-icon></md-icon>
                            <input type="text" name="lastName">
                        </md-input-container>
                        <md-input-container class="md-icon-float" flex>
                            <label>Отчество</label>
                            <md-icon></md-icon>
                            <input type="text" name="fatherName">
                        </md-input-container>
                        <md-input-container class="md-icon-float" flex>
                            <label>Электронная почта</label>
                            <md-icon>mail</md-icon>
                            <input type="email" name="email">
                        </md-input-container>
                        <md-input-container class="md-icon-float" flex>
                            <label>Пароль</label>
                            <md-icon>lock</md-icon>
                            <input type="password" name="password">
                        </md-input-container>
                        <md-input-container class="md-icon-float" flex>
                            <label>Повторите пароль</label>
                            <md-icon></md-icon>
                            <input type="password" name="confirmPassword">
                        </md-input-container>
                        <input type="radio" name="userType" value="student">Student<br>
                        <input type="radio" name="userType" value="tutor">Tutor<br>
                        <input type="radio" name="userType" value="admin">Admin<br>
                        <md-button class="md-fab md-accent" type="submit">
                            <md-icon>done</md-icon>
                        </md-button>
                    </form>
                </md-card-content>
                <div class="md-actions" layout="row" layout-align="end center">
                    <md-button>Отмена</md-button>
                    <md-button type="submit">Зарегистрироваться</md-button>
                </div>
            </md-card>
        </md-content>

    </div>
</div>

</body>
</html>