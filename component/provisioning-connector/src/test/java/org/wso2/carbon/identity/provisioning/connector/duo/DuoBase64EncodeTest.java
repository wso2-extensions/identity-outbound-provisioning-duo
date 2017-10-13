/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.wso2.carbon.identity.provisioning.connector.duo;

import org.apache.commons.codec.binary.Base64;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.wso2.carbon.identity.provisioning.duo.DuoBase64;

import java.io.IOException;
import java.util.Arrays;

/**
 * Unit test case for DuoBase64
 */
public class DuoBase64EncodeTest {

    @Test
    public void testEncode() throws IOException {
        String orginal = "testEncode";
        String encodedString = DuoBase64.encodeBytes(orginal.getBytes());
        Assert.assertEquals(DuoBase64.encodeBytes(orginal.getBytes()), "dGVzdEVuY29kZQ==");
        Assert.assertEquals(DuoBase64.decode(encodedString), orginal.getBytes());
    }
}
