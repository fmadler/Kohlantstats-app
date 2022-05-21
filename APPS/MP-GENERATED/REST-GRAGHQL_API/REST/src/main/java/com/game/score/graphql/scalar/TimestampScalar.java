/**
	* Copyright (c) minuteproject, minuteproject@gmail.com
	* All rights reserved.
	* 
	* Licensed under the Apache License, Version 2.0 (the "License")
	* you may not use this file except in compliance with the License.
	* You may obtain a copy of the License at
	* 
	* http://www.apache.org/licenses/LICENSE-2.0
	* 
	* Unless required by applicable law or agreed to in writing, software
	* distributed under the License is distributed on an "AS IS" BASIS,
	* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	* See the License for the specific language governing permissions and
	* limitations under the License.
	* 
	* More information on minuteproject:
	* twitter @minuteproject
	* wiki http://minuteproject.wikispaces.com 
	* blog http://minuteproject.blogspot.net
	* 
*/
/**
	* template reference : 
	* - Minuteproject version : 0.9.11
	* - name      : GraphQL.TimestampScalar
	* - file name : GraphQL.TimestampScalar.vm
*/
package com.game.score.graphql.scalar;

import graphql.Internal;
import graphql.language.IntValue;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;

import java.math.BigInteger;
import java.util.GregorianCalendar;

/**
* Access this via {@link graphql.scalars.ExtendedScalars#Date}
*/
@Internal
public class TimestampScalar  {

    public static GraphQLScalarType INSTANCE;

    static {
        Coercing<Object, Object> coercing = new Coercing<Object, Object>() {
            @Override
            public Object serialize(Object input) {
                return input;
            }

            @Override
            public Object parseValue(Object input) {
                GregorianCalendar calendar = new GregorianCalendar();
                calendar.setTimeInMillis(((IntValue)input).getValue().multiply(new BigInteger("1000")).longValue());
                return calendar;
            }

            @Override
            public Object parseLiteral(Object input) {
                GregorianCalendar calendar = new GregorianCalendar();
                calendar.setTimeInMillis(((IntValue)input).getValue().multiply(new BigInteger("1000")).longValue());

                return calendar;
            }

        };

        INSTANCE = GraphQLScalarType.newScalar()
            .name("Timestamp")
            .description("An implementation of Timestamp Scalar")
            .coercing(coercing)
            .build();
    }
}
