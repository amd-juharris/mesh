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
package runtime.intrinsic.tran;

import runtime.intrinsic.IntrinsicLambda;
import runtime.tran.Box;

/**
 * Return the value held in a box.
 *
 * @author Basil Hosmer
 */
public final class _get extends IntrinsicLambda
{
    public static final _get INSTANCE = new _get(); 
    public static final String NAME = "get";

    public String getName()
    {
        return NAME;
    }

    public Object apply(final Object arg)
    {
        return invoke((Box)arg);
    }

    public static Object invoke(final Box box)
    {
        return box.getValue();
    }
}
