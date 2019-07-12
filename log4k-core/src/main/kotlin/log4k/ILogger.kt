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

/**
 * Logging interface
 * @property isTraceEnabled Getting trace level is enable.
 * @property isDebugEnabled Getting debug level is enable.
 * @property isInfoEnabled Getting information level is enable.
 * @property isWarningEnabled Getting warning level is enable.
 */
interface ILogger {

    val isTraceEnabled: Boolean

    val isDebugEnabled: Boolean

    val isInfoEnabled: Boolean

    val isWarningEnabled: Boolean

    /**
     * Write log with exception information at trace level.
     * @param message write message.
     * @param throwable exception.
     */
    fun trace(message: String, throwable: Throwable? = null)

    /**
     * Write log with exception information at debug level.
     * @param message write message.
     * @param throwable exception.
     */
    fun debug(message: String, throwable: Throwable? = null)

    /**
     * Write log with exception information at information level.
     * @param message write message.
     * @param throwable exception.
     */
    fun info(message: String, throwable: Throwable? = null)

    /**
     * Write log with exception information at warning level.
     * @param message write message.
     * @param throwable exception.
     */
    fun warn(message: String, throwable: Throwable? = null)

    /**
     * Write log with exception information at error level.
     * @param message write message.
     * @param throwable exception.
     */
    fun error(message: String, throwable: Throwable? = null)
}