/*
  * JBoss, Home of Professional Open Source
  * Copyright 2005, JBoss Inc., and individual contributors as indicated
  * by the @authors tag. See the copyright.txt in the distribution for a
  * full listing of individual contributors.
  *
  * This is free software; you can redistribute it and/or modify it
  * under the terms of the GNU Lesser General Public License as
  * published by the Free Software Foundation; either version 2.1 of
  * the License, or (at your option) any later version.
  *
  * This software is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
  * Lesser General Public License for more details.
  *
  * You should have received a copy of the GNU Lesser General Public
  * License along with this software; if not, write to the Free
  * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
  * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
  */
package org.jboss.tm;

import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;

/**
 * The interface to implementated by a transaction manager
 * that supports retrieving the current threads transaction timeout
 *
 * @author <a href="mailto:adrian@jboss.org">Adrian Brock</a>
 * @version $Revision: 37459 $
 */
public interface TransactionTimeoutConfiguration
{
   /**
    * Get the transaction timeout.
    * 
    * @return the timeout in seconds associated with this thread
    * @throws SystemException for any error
    */
   int getTransactionTimeout() throws SystemException;

   /**
    * Get the time left before transaction timeout
    * 
    * @param errorRollback throw an error if the transaction is marked for rollback
    * @return the remaining in the current transaction or -1
    * if there is no transaction
    * @throws RollbackException if the transaction is marked for rollback and
    * errorRollback is true
    */
   long getTimeLeftBeforeTransactionTimeout(boolean errorRollback) throws RollbackException;
}
