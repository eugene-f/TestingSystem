<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<md-dialog aria-label="RegistrationDialog" flex="33">
    <md-toolbar>
        <div class="md-toolbar-tools">
            <h2>Регистрация</h2>
            <span flex></span>
            <md-button class="md-icon-button" ng-click="answer('not applicable')">
                <md-icon aria-label="Close">cancel</md-icon>
            </md-button>
        </div>
    </md-toolbar>
    <md-dialog-content>
        <%@ include file="registration_form.html" %>
    </md-dialog-content>
    <!--<div class="md-actions" layout="row">-->
        <!--<span flex></span>-->
        <!--<md-button ng-click="answer('not useful')" class="md-primary">-->
            <!--Отмена-->
        <!--</md-button>-->
        <!--<md-button ng-click="answer('useful')" class="md-primary">-->
            <!--Зарегистрироваться-->
        <!--</md-button>-->
    <!--</div>-->
</md-dialog>