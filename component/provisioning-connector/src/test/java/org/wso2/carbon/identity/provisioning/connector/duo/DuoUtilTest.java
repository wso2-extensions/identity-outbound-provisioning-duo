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

import org.powermock.reflect.Whitebox;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.wso2.carbon.identity.provisioning.duo.DuoUtil;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Unit test case for DuoUtil class
 */
public class DuoUtilTest {
    DuoUtil duoUtil;

    @BeforeMethod
    public void setUp() {
        duoUtil = new DuoUtil();
        initMocks(this);
    }

    @Test
    public void testJoin() throws Exception {
        ArrayList<String> args = new ArrayList<>();
        args.add("arg1");
        args.add("arg2");
        Assert.assertEquals(Whitebox.invokeMethod(duoUtil,"join", args.toArray(), "$"),
                "arg1$arg2");
    }

    @Test
    public void testBytes_to_hex() {
        byte[] b  = new byte[100];
        Assert.assertEquals(DuoUtil.bytes_to_hex(b), bytes_to_hex(b));
    }

    @Test
    public void testHmacSha1() throws InvalidKeyException, NoSuchAlgorithmException {
        String input = "Hello World";
        byte[] bytes = input.getBytes(Charset.forName("UTF-8"));
        Assert.assertNotNull(DuoUtil.hmacSha1(bytes, bytes));
    }

    private static String bytes_to_hex(byte[] b) {
        String result = "";
        for (byte aB : b) {
            result += Integer.toString((aB & 0xff) + 0x100, 16).substring(1);
        }
        return result;
    }
}
