/*

   Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/

package org.apache.batik.transcoder.wmf.tosvg;

import java.util.List;
import java.util.ArrayList;

/**
 * This is used to keep data while processing WMF-files.
 * It is tagged with a type and holds a list of Integer-objects.
 * It seems, it might be rewritten to keep just the plain int-data.
 *
 * @author <a href="mailto:bella.robinson@cmis.csiro.au">Bella Robinson</a>
 * @version $Id: FontFamilyResolver.java 478188 2006-11-22 15:19:17Z dvholten $
 */
public class MetaRecord /*implements Serializable*/ {

    public int functionId;
    public int numPoints;

    private final List ptVector = new ArrayList();

    public MetaRecord() {
    }

    public void EnsureCapacity( int cc ) {
    }

    public void AddElement( Object obj ) {
        ptVector.add( obj );
    }

    /**
     * if you dont really need the Integer-object from this method
     * it is recommended to use the <code>elementAt()</code>-method instead,
     * which returns an <code>int</code>.
     */
    public Integer ElementAt( int offset ) {
        return (Integer)ptVector.get( offset );
    }

    /**
     * helper-method to return the plain int-value from the record
     * and save the .intValue()-call at the caller's site.
     * @param offset of the element to get
     * @return the intValue of the element at offset
     */
    public int elementAt( int offset ){
        return ((Integer)ptVector.get( offset )).intValue();
    }

    /** A record that contain byte arrays elements.
     */
    public static class ByteRecord extends MetaRecord {
        public final byte[] bstr;

        public ByteRecord(byte[] bstr) {
            this.bstr = bstr;
        }
    }

    public static class StringRecord extends MetaRecord /*implements Serializable*/ {
        public final String text;

        public StringRecord( String newText ) {
            text = newText;
        }
    }
}
