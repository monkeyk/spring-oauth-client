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

<h2>authorization_code</h2>

<div ng-controller="AuthorizationCodeCtrl">

    <form action="authorization_code" method="post">
        <p>
            <label>
                AuthorizationUri: <input type="text" name="userAuthorizationUri"
                                         size="50" required="required" ng-model="userAuthorizationUri"/>
            </label>
            <a href="${userAuthorizationUri}" target="_blank">Test Connection</a>
        </p>

        <p>
            <label>
                response_type(Fixed): <input type="text" name="responseType" readonly="readonly"
                                             ng-model="responseType"/>
            </label>
        </p>

        <p>
            <label>
                scope: <select name="scope" ng-model="scope">
                <option value="read">read</option>
                <option value="write">write</option>
                <option value="read,write">read,write</option>
            </select>
            </label>
        </p>

        <p>
            <label>
                client_id: <input type="text" name="clientId" required="required"
                                  ng-model="clientId"/> -- 'unity-client' or 'mobile-client'
            </label>
        </p>

        <p>
            <label>
                redirect_uri: <input type="text" name="redirectUri"
                                     required="required" size="50" ng-model="redirectUri"/>
                <br/>
                -- The URI handle in 'OauthController.java', use it get 'code' from server, valid 'state' and retrieve
                access_token.
            </label>
        </p>

        <p>
            <label>
                state(optional): <input type="text" name="state" size="50" ng-model="state"/> -- A random value
            </label>
        </p>


        <br/>

        <div style="border:1px solid #eee;">
            <span style="color:#d3d3d3;">Final send to 'Oauth Server' URL:</span>
            <br/>
            <strong>{{userAuthorizationUri}}?response_type={{responseType}}&scope={{scope}}&client_id={{clientId}}&redirect_uri={{redirectUri}}&state={{state}}</strong>
        </div>
        <br/>
        <button type="submit">Submit</button>
        <span style="color:#d3d3d3;">Submit success will redirect to 'Oauth Server' login page</span>
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