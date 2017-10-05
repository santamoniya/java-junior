package com.acme.edu.iteration02;

import com.acme.edu.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    private static final String LINE_SEPARATOR = "\n";

    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion



    //TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.log("str 2");
        Logger.log(0);
        Logger.close();
        //endregion

        //region then
        assertSysoutContains(
            "string: str 1" + LINE_SEPARATOR + "primitive: 3" + LINE_SEPARATOR +
                    "string: str 2" + LINE_SEPARATOR +
                    "primitive: 0" + LINE_SEPARATOR
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Logger.log("str 1");
        Logger.log(-10);
        Logger.log(Integer.MIN_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + LINE_SEPARATOR +
                    "primitive: -10" + LINE_SEPARATOR +
            Integer.MIN_VALUE + LINE_SEPARATOR +
                    "string: str 2" + LINE_SEPARATOR +
                    "primitive: 0" + LINE_SEPARATOR
        );
        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log((byte)Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + LINE_SEPARATOR +
                    "primitive: 10" + LINE_SEPARATOR +
            Byte.MAX_VALUE + LINE_SEPARATOR +
                    "string: str 2" + LINE_SEPARATOR +
                    "primitive: 0" + LINE_SEPARATOR
        );
        //endregion
    }

    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.close();
        //endregion

        //region then
        assertSysoutEquals(
            "string: str 1" + LINE_SEPARATOR +
                    "string: str 2 (x2)" + LINE_SEPARATOR +
                    "primitive: 0" + LINE_SEPARATOR +
                    "string: str 2" + LINE_SEPARATOR +
                    "string: str 3 (x3)" + LINE_SEPARATOR
        );
        //endregion
    }


}