<%--
 * 
 * @author Shengzhao Li
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Get access_token</title>
</head>
<body>
<a href="${contextPath}/">Home</a>

<h2>Get access_token
    <small>Use 'code' exchange 'access_token'</small>
</h2>


<div ng-controller="CodeAccessTokenCtrl">

    <form action="code_access_token" method="post" class="form-horizontal">
        <div class="form-group">
            <label class="col-sm-2 control-label">AccessTokenUri</label>

            <div class="col-sm-10">
                <div class="input-group">
                    <input type="text" name="accessTokenUri" readonly="readonly"
                           class="form-control" ng-model="accessTokenUri"/>
                    <span class="input-group-addon">
                        <a href="${accessTokenDto.accessTokenUri}" target="_blank">Test Connection</a>
                    </span>
                </div>
                <p class="help-block">
                    AccessTokenUri value from 'spring-oauth-client.properties'
                </p>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">grant_type(Fixed)</label>

            <div class="col-sm-10">
                <input type="text" name="grantType" readonly="readonly"
                       class="form-control" ng-model="grantType"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">client_id</label>

            <div class="col-sm-10">
                <input type="text" name="clientId" required="required"
                       class="form-control" ng-model="clientId" readonly="readonly"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">client_secret</label>

            <div class="col-sm-10">
                <input type="text" name="clientId" required="required"
                       class="form-control" ng-model="clientId" readonly="readonly"/>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">code</label>

            <div class="col-sm-10">
                <input type="text" name="code" required="required" class="form-control"
                       ng-model="code" readonly="readonly"/>

                <p class="help-block">Value from 'Oauth Server'</p>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">redirect_uri</label>

            <div class="col-sm-10">
                <input type="text" name="redirectUri" readonly="readonly" class="form-control"
                       required="required" size="50" ng-model="redirectUri"/>

                <p class="help-block">The URI must be match the prev step 'redirect_uri'</p>
            </div>
        </div>


        <div class="well well-sm">
            <span class="text-muted">Final get 'access_token' URL:</span>
            <br/>

            <div class="text-primary">
                {{accessTokenUri}}?client_id={{clientId}}&client_secret={{clientSecret}}&grant_type={{grantType}}&redirect_uri={{redirectUri}}&code={{code}}
            </div>
        </div>
        <br/>
        <button type="submit" class="btn btn-primary">Get Access Token</button>
        <span class="text-muted">Will go to 'redirect_uri'</span>
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