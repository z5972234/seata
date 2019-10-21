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

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 如果是用 GlobalLock 修饰的本地业务方法，虽然该方法并非某个全局事务下的分支事务，但是它对数据资源的操作也需要先查询全局锁，
 * 如果存在其他 Seata 全局事务正在修改，则该方法也需等待。所以，如果想要Seata 全局事务执行期间，数据库不会被其他事务修改，
 * 则该方法需要强制添加 GlobalLock 注解，来将其纳入 Seata 分布式事务的管理范围。
 *
 * 功能有点类似于 Spring 的 @Transactional 注解，如果你希望开启事务，那么必须添加该注解，如果你没有添加那么事务功能自然不生效，
 * 业务可能出 BUG；Seata 也一样，如果你希望某个不在全局事务下的 SQL 操作不影响 AT 分布式事务，那么必须添加 GlobalLock 注解。
 *
 * declare the transaction only execute in single local RM,<br/>
 * but the transaction need to ensure records to update(or select for update) is not in global transaction middle
 * stage<br/>
 *
 * use this annotation instead of GlobalTransaction in the situation mentioned above will help performance.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface GlobalLock {
}
