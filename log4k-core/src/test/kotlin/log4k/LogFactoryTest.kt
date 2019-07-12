/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * MIT License
 *
 * Copyright (c) 2019 Jun Kurihara
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package log4k

import kotlin.test.Test
import kotlin.test.asserter

class LogFactoryTest {
    @Test
    fun getLoggerByStringTest() {
        val logger = LogFactory.getLogger("aaa")
        asserter.assertTrue("isTraceEnabled is wrong", logger.isTraceEnabled)
        asserter.assertTrue("isDebugEnabled is wrong", logger.isDebugEnabled)
        asserter.assertTrue("isInfoEnabled is wrong", logger.isInfoEnabled)
        asserter.assertTrue("isWarningEnabled is wrong", logger.isWarningEnabled)

        asserter.run {
            logger.trace("trace without exception")
            logger.trace("trace with exception", Error("Some error"))
            logger.debug("debug without exception")
            logger.debug("debug with exception", Error("Some error"))
            logger.info("info without exception")
            logger.info("info with exception", Error("Some error"))
            logger.warn("warn without exception")
            logger.warn("warn with exception", Error("Some error"))
            logger.error("error without exception")
            logger.error("error with exception", Error("Some error"))
        }
    }

    @Test
    fun getLoggerByClassTest() {
        val logger = LogFactory.getLogger(String::class.java)
        asserter.assertTrue("isTraceEnabled is wrong", logger.isTraceEnabled)
        asserter.assertTrue("isDebugEnabled is wrong", logger.isDebugEnabled)
        asserter.assertTrue("isInfoEnabled is wrong", logger.isInfoEnabled)
        asserter.assertTrue("isWarningEnabled is wrong", logger.isWarningEnabled)

        asserter.run {
            logger.trace("trace without exception")
            logger.trace("trace with exception", Error("Some error"))
            logger.debug("debug without exception")
            logger.debug("debug with exception", Error("Some error"))
            logger.info("info without exception")
            logger.info("info with exception", Error("Some error"))
            logger.warn("warn without exception")
            logger.warn("warn with exception", Error("Some error"))
            logger.error("error without exception")
            logger.error("error with exception", Error("Some error"))
        }
    }
}