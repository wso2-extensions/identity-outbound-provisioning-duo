/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.carbon.identity.provisioning.connector.duo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockObjectFactory;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;
import org.wso2.carbon.identity.provisioning.duo.DuoConnectorConstants;
import org.wso2.carbon.identity.provisioning.duo.DuoProvisioningConnectorConfig;

import java.util.ArrayList;
import java.util.Properties;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@PrepareForTest({LogFactory.class})
public class DuoProvisioningConnectorConfigTest {

    @Mock
    private Log log;

    @DataProvider(name = "getValuesProvider")
    public Object[][] provideGetValueData() {

        Properties properties1 = new Properties();
        properties1.setProperty(DuoConnectorConstants.API_USER, "admin");

        Properties properties2 = new Properties();

        return new Object[][]{
                {properties1, "admin"},
                {properties2, null}
        };
    }

    @Test(dataProvider = "getValuesProvider")
    public void testGetValue(Properties properties, String expectedValue) throws Exception {
        setLogging(false);
        DuoProvisioningConnectorConfig connectorConfig = new DuoProvisioningConnectorConfig(properties);

        Assert.assertEquals(connectorConfig.getValue(DuoConnectorConstants.API_USER),
                            expectedValue);
    }

    @Test
    public void testGetUserIdClaim() throws Exception {
        DuoProvisioningConnectorConfig connectorConfig = new DuoProvisioningConnectorConfig(new Properties());
        Assert.assertNull(connectorConfig.getUserIdClaim());
    }

    @Test
    public void testGetRequiredAttributeNames() throws Exception {
        DuoProvisioningConnectorConfig connectorConfig = new DuoProvisioningConnectorConfig(new Properties());
        Assert.assertEquals(connectorConfig.getRequiredAttributeNames(), new ArrayList<String>());
    }

    private void setLogging(boolean debugEnabled) {

        mockStatic(LogFactory.class);
        when(LogFactory.getLog(any(Class.class))).thenReturn(log);

        doNothing().when(log).warn(Matchers.any());

        when(log.isDebugEnabled()).thenReturn(debugEnabled);
        doNothing().when(log).debug(any());
    }

    @ObjectFactory
    public IObjectFactory getObjectFactory() {
        return new PowerMockObjectFactory();
    }
}
