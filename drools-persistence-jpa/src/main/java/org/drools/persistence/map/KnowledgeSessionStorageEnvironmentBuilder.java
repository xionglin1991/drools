/*
 * Copyright 2015 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.drools.persistence.map;

import org.drools.persistence.PersistenceContextManager;
import org.drools.persistence.TransactionManager;

public class KnowledgeSessionStorageEnvironmentBuilder implements EnvironmentBuilder {

    private MapBasedPersistenceContext persistenceContext;
    private KnowledgeSessionStorage storage;

    public KnowledgeSessionStorageEnvironmentBuilder(KnowledgeSessionStorage storage) {
        this.storage = storage;
        this.persistenceContext = new MapBasedPersistenceContext( storage );
    }
    
    /* (non-Javadoc)
     * @see org.kie.api.persistence.map.EnvironmentBuilder#getPersistenceContextManager()
     */
    public PersistenceContextManager getPersistenceContextManager(){
        return new MapPersistenceContextManager( persistenceContext );
    }
    
    /* (non-Javadoc)
     * @see org.kie.api.persistence.map.EnvironmentBuilder#getTransactionManager()
     */
    public TransactionManager getTransactionManager(){
        return new ManualTransactionManager( persistenceContext, storage );
    }
}
