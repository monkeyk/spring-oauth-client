<%--
 * 
 * @author Shengzhao Li
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get access_token</title>
</head>
<body>
<a href="${contextPath}/">Home</a>

<h2>Get access_token</h2>


<div ng-controller="CodeAccessTokenCtrl">

    <form action="code_access_token" method="post">
        <p>
            <label>
                AccessTokenUri: <input type="text" size="50" name="accessTokenUri" readonly="readonly"
                                       ng-model="accessTokenUri"/>
            </label>
            <a href="${accessTokenDto.accessTokenUri}" target="_blank">Test Connection</a>
        </p>

        <p>
            <label>
                grant_type(Fixed): <input type="text" name="grantType" readonly="readonly"
                                          ng-model="grantType"/>
            </label>
        </p>

        <p>
            <label>
                client_id: <input type="text" name="clientId" required="required"
                                  ng-model="clientId" readonly="readonly"/>
            </label>
        </p>

        <p>
            <label>
                client_secret: <input type="text" name="clientSecret" required="required"
                                      ng-model="clientSecret" readonly="readonly"/>
            </label>
        </p>

        <p>
            <label>
                code: <input type="text" name="code" required="required"
                             ng-model="code" readonly="readonly"/> -- Value from 'Oauth Server'
            </label>
        </p>

        <p>
            <label>
                redirect_uri: <input type="text" name="redirectUri" readonly="readonly"
                                     required="required" size="50" ng-model="redirectUri"/>
                <br/>
                -- The URI must be match the prev step 'redirect_uri'
            </label>
        </p>

        <br/>

        <div style="border:1px solid #eee;">
            <span style="color:#d3d3d3;">Final get 'access_token' URL:</span>
            <br/>
            <strong>{{accessTokenUri}}?client_id={{clientId}}&client_secret={{clientSecret}}&grant_type={{grantType}}&redirect_uri={{redirectUri}}&code={{code}}</strong>
        </div>
        <br/>
        <button type="submit">Get Access Token</button>
        <span style="color:#d3d3d3;">Will go to 'redirect_uri'</span>
    </form>

</div>

<script>
    var CodeAccessTokenCtrl = ['$scope', function ($scope) {
        $scope.accessTokenUri = '${accessTokenDto.accessTokenUri}';
        $scope.grantType = '${accessTokenDto.grantType}';
        $scope.clientId = 'unity-client';

        $scope.clientSecret = 'unity';
        $scope.code = '${accessTokenDto.code}';
        $scope.redirectUri = '${host}authorization_code_callback';

    }];
</script>

</body>
</html>