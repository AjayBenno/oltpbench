/******************************************************************************
 *  Copyright 2015 by OLTPBenchmark Project                                   *
 *                                                                            *
 *  Licensed under the Apache License, Version 2.0 (the "License");           *
 *  you may not use this file except in compliance with the License.          *
 *  You may obtain a copy of the License at                                   *
 *                                                                            *
 *    http://www.apache.org/licenses/LICENSE-2.0                              *
 *                                                                            *
 *  Unless required by applicable law or agreed to in writing, software       *
 *  distributed under the License is distributed on an "AS IS" BASIS,         *
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  *
 *  See the License for the specific language governing permissions and       *
 *  limitations under the License.                                            *
 ******************************************************************************/

package com.oltpbenchmark.benchmarks.tpch.queries;

import com.oltpbenchmark.api.SQLStmt;
import java.lang.System;

public class Q8 extends GenericQuery {

    public final SQLStmt query_stmt = new SQLStmt(
              "select "
            +     "o_year, "
            +     "sum(case "
            +         "when nation = 'CANADA' then volume "
            +         "else 0 "
            +     "end) / sum(volume) as mkt_share "
            + "from "
            +     "( "
            +         "select "
            +             "extract(year from o_orderdate) as o_year, "
            +             "l_extendedprice * (1 - l_discount) as volume, "
            +             "n2.n_name as nation "
            +         "from "
            +             "part, "
            +             "supplier, "
            +             "lineitem, "
            +             "orders, "
            +             "customer, "
            +             "nation n1, "
            +             "nation n2, "
            +             "region "
            +         "where "
            +             "p_partkey = l_partkey "
            +             "and s_suppkey = l_suppkey "
            +             "and l_orderkey = o_orderkey "
            +             "and o_custkey = c_custkey "
            +             "and c_nationkey = n1.n_nationkey "
            +             "and n1.n_regionkey = r_regionkey "
            +             "and r_name = 'AMERICA' "
            +             "and s_nationkey = n2.n_nationkey "
            +             "and o_orderdate between date('1995-01-01') and date('1996-12-31') "
            +             "and p_type = 'ECONOMY POLISHED STEEL' "
            +     ") as all_nations "
            + "group by "
            +     "o_year "
            + "order by "
            +     "o_year"
        );

    protected SQLStmt get_query() {
	System.out.println("Q8");
        return new SQLStmt("SELECT 1");
//	return null;
    }
}
