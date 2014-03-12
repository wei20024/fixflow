/**
 * Copyright 1996-2013 Founder International Co.,Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author kenshin
 */
package com.founder.fix.fixflow.core.internationalization;

/**
 * 异常信息的国际化key
 * @author ych
 *
 */
public interface ExceptionCode {
	public static String EXCEPTION_DEFAULT = "exception_default";
	public static String CLASSLOAD_EXCEPTION_DEFAULT = "classloadException_default";
	public static String CLASSLOAD_EXCEPTION_FILENOTFOUND = "classloadException_filenotfound";
	public static String CLASSLOAD_EXCEPTION_ENCODING = "classloadException_encoding";
	public static String CLASSLOAD_EXCEPTION = "classloadException";
	public static String CLASSLOAD_EXCEPTION_DCUMENT = "classloadException_document";
	public static String JOB_EXCEPTION_DEFAULT = "jobException_default";
	
	
	/* 表达式执行异常 */
	
	/**
	 * 跳过策略表达式异常编码
	 */
	public static String EXPRESSION_EXCEPTION_SKIPSTRATEGY = "expressionException_skipStrategy";
	
	/**
	 * 输出结果集表达式集合验证
	 */
	public static String EXPRESSION_EXCEPTION_LOOPDATAOUTPUTCOLLECTION_COLLECTIONCHECK = "expressionException_loopDataOutputCollection_collectionCheck";
	
	/**
	 * 多实例输入数据集异常编码
	 */
	public static String EXPRESSION_EXCEPTION_LOOPDATAINPUTCOLLECTIONEXPRESSION = "expressionException_loopDataInputCollectionExpression";
	
	/**
	 * 多实例输入数据集集合数量为0
	 */
	public static String EXPRESSION_EXCEPTION_LOOPDATAINPUTCOLLECTIONEMPTY = "expressionException_loopDataInputCollectionEmpty";
	
}
