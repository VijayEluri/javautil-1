/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.commons.collections;

import java.util.TreeMap;
import org.apache.commons.collections.map.AbstractTestMap;

/**
 * Tests TreeMap.
 *
 * @author Jason van Zyl
 * @version $Revision: 534976 $ $Date: 2007-05-03 15:54:44 -0400 (Thu, 03 May 2007) $
 */
public abstract class TestTreeMap extends AbstractTestMap {

    public TestTreeMap( String testName ) {
        super(testName);
    }

    public static void main( String args[] ) {
        String[] testCaseName = { TestTreeMap.class.getName() };
        junit.textui.TestRunner.main(testCaseName);
    }

    public boolean isAllowNullKey() {
        return false;
    }

    protected TreeMap map = null;

    public void setUp() {
        map = (TreeMap) makeEmptyMap();
    }

    public void testNewMap() {
        assertTrue("New map is empty", map.isEmpty());
        assertEquals("New map has size zero", 0, map.size());
    }

    public void testSearch() {
        map.put("first", "First Item");
        map.put("second", "Second Item");
        assertEquals("Top item is 'Second Item'",
                "First Item", map.get("first"));
        assertEquals("Next Item is 'First Item'",
                "Second Item", map.get("second"));
    }
}
