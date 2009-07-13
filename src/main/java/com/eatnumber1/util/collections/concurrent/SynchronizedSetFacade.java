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

package com.eatnumber1.util.collections.concurrent;

import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import org.jetbrains.annotations.NotNull;

/**
 * @author Russell Harmon
 * @since Jul 13, 2009
 */
public class SynchronizedSetFacade<T, D extends Set<T>> extends SynchronizedCollectionFacade<T, D> implements SynchronizedSet<T, D> {
    public SynchronizedSetFacade( D delegate, @NotNull Lock lock ) {
        super(delegate, lock);
    }

    public SynchronizedSetFacade( @NotNull D delegate, @NotNull ReadWriteLock lock ) {
        super(delegate, lock);
    }

    public SynchronizedSetFacade( @NotNull D delegate ) {
        super(delegate);
    }
}