/*
 *  Copyright 1999-2019 Seata.io Group.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.seata.spring.annotation;

import io.seata.tm.api.transaction.TransactionInfo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The interface Global transactional.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface GlobalTransactional {

    /**
     * 全局事务超时时间，默认60000毫秒
     *
     * @return timeoutMills in MILLISECONDS.
     */
    int timeoutMills() default TransactionInfo.DEFAULT_TIME_OUT;

    /**
     * 全局事务名称
     *
     * @return Given name.
     */
    String name() default "";

    /**
     * 回滚的异常
     * @return
     */
    Class<? extends Throwable>[] rollbackFor() default {};

    /**
     *  回滚的异常
     * @return
     */
    String[] rollbackForClassName() default {};

    /**
     * 不回滚的异常
     * @return
     */
    Class<? extends Throwable>[] noRollbackFor() default {};

    /**
     * 不回滚的异常
     * @return
     */
    String[] noRollbackForClassName() default {};


}
