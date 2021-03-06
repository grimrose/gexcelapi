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

import org.jggug.kobo.gexcelapi.CellLabelUtils as CLU

class CellLabelIterator implements Iterator<Iterable<String>> {

    private final int beginRow
    private final int beginColumn
    private final int endRow // inclusive
    private final int endColumn // inclusive

    private int nextRow

    CellLabelIterator(beginRow, beginColumn, endRow, endColumn) {
        this.beginRow = beginRow
        this.beginColumn = beginColumn
        this.endRow = endRow
        this.endColumn = endColumn
        this.nextRow = beginRow
    }

    CellLabelIterator(beginLabel, endLabel) {
        this(
            CLU.rowIndex(beginLabel),
            CLU.columnIndex(beginLabel),
            CLU.rowIndex(endLabel),
            CLU.columnIndex(endLabel)
        )
    }

    boolean hasNext() {
        nextRow <= endRow
    }

    /**
     * Return labels in a next row.
     */
    Iterable<String> next() {
        if (!hasNext()) { throw new NoSuchElementException("out of range") }
        def columnsInARow = (beginColumn..endColumn).collect{ column ->
            CLU.cellLabel(nextRow, column)
        }
        nextRow++
        return columnsInARow
    }

    void remove() {
        throw new UnsupportedOperationException('read only')
    }

}

