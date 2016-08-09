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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.provisioning.IdentityProvisioningException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DuoProvisioningConnectorConfig implements Serializable {

    private static final long serialVersionUID = 1466757093641438420L;

    private static final Log log = LogFactory.getLog(DuoProvisioningConnectorConfig.class);
    private Properties configs;

    public DuoProvisioningConnectorConfig(Properties configs) {
        this.configs = configs;
    }

    public List<String> getRequiredAttributeNames() {
        List<String> requiredAttributeList = new ArrayList<String>();
        //Add your code to get the required attributes names
        return requiredAttributeList;
    }

    public String getUserIdClaim() throws IdentityProvisioningException {
        //Add the your code to get the userID claim
        return null;
    }

    public String getValue(String key) {
        return this.configs.getProperty(key);
    }
}