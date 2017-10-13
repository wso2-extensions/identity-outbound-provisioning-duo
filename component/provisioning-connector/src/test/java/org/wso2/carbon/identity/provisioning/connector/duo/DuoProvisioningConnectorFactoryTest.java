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
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockObjectFactory;
import org.powermock.reflect.Whitebox;
import org.testng.Assert;
import org.testng.IObjectFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.ObjectFactory;
import org.testng.annotations.Test;
import org.wso2.carbon.identity.application.common.model.Property;
import org.wso2.carbon.identity.provisioning.AbstractOutboundProvisioningConnector;
import org.wso2.carbon.identity.provisioning.duo.DuoProvisioningConnector;
import org.wso2.carbon.identity.provisioning.duo.DuoProvisioningConnectorFactory;

import static org.mockito.Matchers.any;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.*;

@PrepareForTest({LogFactory.class})
public class DuoProvisioningConnectorFactoryTest {

    private static final String CONNECTOR_TYPE = "duo";
    private DuoProvisioningConnectorFactory duoProvisioningConnectorFactory;

    @Mock
    private Log log;

    @Mock DuoProvisioningConnectorFactory duo;


    @BeforeMethod
    public void setUp() {
        duoProvisioningConnectorFactory = new DuoProvisioningConnectorFactory();
        initMocks(this);
    }

    @Test
    public void testGetConnectorType() throws Exception {

        mockStatic(LogFactory.class);
        when(LogFactory.getLog(any(Class.class))).thenReturn(log);

        DuoProvisioningConnectorFactory duoProvisioningConnectorFactory = new
                DuoProvisioningConnectorFactory();

        Assert.assertEquals(duoProvisioningConnectorFactory.getConnectorType(), CONNECTOR_TYPE);
    }

    @ObjectFactory
    public IObjectFactory getObjectFactory() {
        return new PowerMockObjectFactory();
    }
}
