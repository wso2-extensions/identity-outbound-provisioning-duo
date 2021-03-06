/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.provisioning.duo;

public class DuoConnectorConstants {

    public static final String API_USER = "/admin/v1/users";
    public static final String API_PHONE = "/admin/v1/phones";
    public static final String SKEY = "skey";
    public static final String IKEY = "ikey";
    public static final String HOST = "host";
    public static final String USERNAME = "username";
    public static final String PHONE_NUMBER = "number";
    public static final String USER_ID = "user_id";
    public static final String PHONE_ID = "phone_id";

    public static class HttpMethods {
        public static final String GET = "GET";
        public static final String POST = "POST";
        public static final String DELETE = "DELETE";
    }

    public static class DuoErrors {
        public static final String ERROR_CREATE_USER = "Error while creating Duo user : ";
        public static final String ERROR_CREATE_PHONE = "Error while creating phone in Duo : ";
        public static final String ERROR_DELETE_USER = "Error while deleting Duo user : ";
        public static final String ERROR_DELETE_PHONE = "Error while deleting phone from the Duo user";
        public static final String ERROR_UPDATE_USER = "Error while updating user in Duo";
        public static final String ERROR_RETRIEVE_PHONE = "Error while retrieving phone ID for the number : ";
        public static final String ERROR_ADDING_PHONE = "Error while adding phone number to Duo user";
        public static final String ERROR_RETRIEVE_PHONE_FOR_USER = "Error while retrieving phone for the Duo user";
    }
}