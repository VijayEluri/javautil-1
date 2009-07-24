/*
 * Copyright 2007 Russell Harmon
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.eatnumber1.util.nio;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import org.jetbrains.annotations.NotNull;
import sun.misc.Cleaner;

/**
 * @author Russell Harmon
 * @since Jul 24, 2009
 */
public class MappedByteBufferUtils {
    private MappedByteBufferUtils() {
    }

    public static void unmap( @NotNull MappedByteBuffer buffer ) {
        try {
            Method cleanerGetter = buffer.getClass().getMethod("cleaner");
            cleanerGetter.setAccessible(true);
            Cleaner cleaner = (sun.misc.Cleaner) cleanerGetter.invoke(buffer);
            cleaner.clean();
        } catch( NoSuchMethodException e ) {
            throw new RuntimeException(e);
        } catch( InvocationTargetException e ) {
            throw new RuntimeException(e);
        } catch( IllegalAccessException e ) {
            throw new RuntimeException(e);
        }
    }
}
