<%--
 * 
 * @author Shengzhao Li
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>authorization_code</title>
</head>
<body>
<a href="${contextPath}/">Home</a>

<h2>authorization_code
    <small>Get 'code' from Oauth Server</small>
</h2>

<div ng-controller="AuthorizationCodeCtrl">

    <form action="authorization_code" method="post" class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 control-label">AuthorizationUri</label>

            <div class="col-sm-10">
                <div class="input-group">
                    <input type="text" name="userAuthorizationUri" class="form-control"
                           readonly="readonly" ng-model="userAuthorizationUri"/>
                    <span class="input-group-addon">
                        <a href="${userAuthorizationUri}" target="_blank">Test Connection</a>
                    </span>
                </div>
                <p class="help-block">
                    AuthorizationUri value from 'spring-oauth-client.properties'
                </p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">response_type(Fixed)</label>

            <div class="col-sm-10">
                <input type="text" name="responseType" readonly="readonly"
                       class="form-control" ng-model="responseType"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">scope</label>

            <div class="col-sm-10">
                <select name="scope" ng-model="scope" class="form-control">
                    <option value="read">read</option>
                    <option value="write">write</option>
                    <option value="read,write">read,write</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">client_id</label>

            <div class="col-sm-10">
                <input type="text" name="clientId" required="required"
                       class="form-control" ng-model="clientId"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">redirect_uri</label>

            <div class="col-sm-10">
                <input type="text" name="redirectUri" readonly="readonly" class="form-control"
                       required="required" size="50" ng-model="redirectUri"/>

                <p class="help-block">
                    Handle the URI in 'OauthController.java', use it get 'code' from server, valid 'state' and retrieve
                    access_token.</p>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">state</label>

            <div class="col-sm-10">
                <input type="text" name="state" size="50" class="form-control" required="required" ng-model="state"/>

                <p class="help-block">
                    A random value</p>
            </div>
        </div>

        <div class="well well-sm">
            <span class="text-muted">Final send to 'Oauth Server' URL:</span>
            <br/>

            <div class="text-primary">
                {{userAuthorizationUri}}?response_type={{responseType}}&scope={{scope}}&client_id={{clientId}}&redirect_uri={{redirectUri}}&state={{state}}
            </div>
        </div>
        <br/>
        <button type="submit" class="btn btn-primary">Submit</button>
        <span class="text-muted">Submit success will redirect to 'Oauth Server' login page</span>
    </form>

</div>

<script>
    var AuthorizationCodeCtrl = ['$scope', function ($scope) {
        $scope.userAuthorizationUri = '${userAuthorizationUri}';
        $scope.responseType = 'code';
        $scope.scope = 'read,write';

        $scope.clientId = 'unity-client';
        $scope.redirectUri = '${host}authorization_code_callback';
        $scope.state = '${state}';

    }];
</script>

</body>
</html>