<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<md-dialog flex="66">

    <md-toolbar>
        <div class="md-toolbar-tools">
            <span>Название теста</span>
            <span flex></span>
            <md-button class="md-icon-button" ng-click="answer('not applicable')">
                <md-icon>cancel</md-icon>
            </md-button>
        </div>
    </md-toolbar>

    <md-dialog-content>
        <%@ include file="solve_test_form.jsp" %>
    </md-dialog-content>

</md-dialog>
