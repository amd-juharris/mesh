/**
 * ADOBE SYSTEMS INCORPORATED
 * Copyright 2009-2013 Adobe Systems Incorporated
 * All Rights Reserved.
 *
 * NOTICE: Adobe permits you to use, modify, and distribute
 * this file in accordance with the terms of the MIT license,
 * a copy of which can be found in the LICENSE.txt file or at
 * http://opensource.org/licenses/MIT.
 */
package runtime.intrinsic;

import runtime.rep.list.ListValue;
import runtime.rep.list.PersistentList;
import runtime.rep.Tuple;

import java.util.Iterator;

/**
 * string version of list cut
 *
 * @author Basil Hosmer
 */
public final class _strcut extends IntrinsicLambda
{
    public static final _strcut INSTANCE = new _strcut(); 
    public static final String NAME = "strcut";

    public String getName()
    {
        return NAME;
    }

    public Object apply(final Object arg)
    {
        final Tuple args = (Tuple)arg;
        return invoke((String)args.get(0), (ListValue)args.get(1));
    }

    public static ListValue invoke(final String s, final ListValue indexes)
    {
        final PersistentList result =
            PersistentList.alloc(indexes.size());

        final Iterator<?> iter = indexes.iterator();

        if (iter.hasNext())
        {
            int i = 0;
            int start = (Integer)iter.next();

            while (iter.hasNext())
            {
                final int end = (Integer)iter.next();
                result.updateUnsafe(i++, s.substring(start, end));
                start = end;
            }

            result.updateUnsafe(i, s.substring(start));
        }

        return result;
    }
}
