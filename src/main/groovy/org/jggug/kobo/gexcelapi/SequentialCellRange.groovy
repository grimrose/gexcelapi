/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jggug.kobo.gexcelapi

import org.apache.poi.ss.usermodel.Sheet

class SequentialCellRange implements Range {

    @Delegate
    private List list

    SequentialCellRange(Sheet sheet, int beginRow, int beginColumn, int endRow, int endColumn) {
        list = new CellLabelIterator(beginRow, beginColumn, endRow, endColumn).collect{ row -> row.collect{ sheet[it] } }.flatten()
    }

    SequentialCellRange(Sheet sheet, String beginCellLabel, String endCellLabel) {
        list = new CellLabelIterator(beginCellLabel, endCellLabel).collect{ row -> row.collect{ sheet[it] } }.flatten()
    }

    boolean validate() {
        list.every { cell -> cell?.validate() }
    }

    @Override
    boolean containsWithinBounds(Object o) {
        list.contains(o)
    }

    @Override
    Comparable getFrom() {
        list.first()
    }

    @Override
    Comparable getTo() {
        list.tail()
    }

    @Override
    String inspect() {
        "#$list"
    }

    @Override
    boolean isReverse() {
        false // fixed
    }

    @Override
    List step(int step) {
        throw new UnsupportedOperationException("not implemented")
    }

    @Override
    void step(int step, Closure closure) {
        throw new UnsupportedOperationException("not implemented")
    }
}
