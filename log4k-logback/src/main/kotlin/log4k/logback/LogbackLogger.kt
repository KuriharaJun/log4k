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

package log4k.logback

import log4k.ILogger
import org.slf4j.LoggerFactory

/**
 * Logger by logback
 *
 * @constructor
 * Initialize logger
 *
 * @param className target class name
 *
 * @property isTraceEnabled Is the logger instance enabled for the TRACE level?
 * @property isDebugEnabled Is the logger instance enabled for the DEBUG level?
 * @property isInfoEnabled Is the logger instance enabled for the INFO level?
 * @property isWarningEnabled Is the logger instance enabled for the WARN level?
 */
class LogbackLogger(className: String) : ILogger {

    private val log: org.slf4j.Logger = LoggerFactory.getLogger(className)

    override val isTraceEnabled: Boolean
        get() = log.isTraceEnabled
    override val isDebugEnabled: Boolean
        get() = log.isDebugEnabled
    override val isInfoEnabled: Boolean
        get() = log.isInfoEnabled
    override val isWarningEnabled: Boolean
        get() = log.isWarnEnabled

    /**
     * Log a message with throwable information at TRACE Level.
     *
     * @param message log message
     * @param throwable log a throwable information
     */
    override fun trace(message: String, throwable: Throwable?) {
        log.trace(message, throwable)
    }

    /**
     * Log a message with throwable information at DEBUG Level.
     *
     * @param message log message
     * @param throwable log a throwable information
     */
    override fun debug(message: String, throwable: Throwable?) {
        log.debug(message, throwable)
    }

    /**
     * Log a message with throwable information at INFO Level.
     *
     * @param message log message
     * @param throwable log a throwable information
     */
    override fun info(message: String, throwable: Throwable?) {
        log.info(message, throwable)
    }

    /**
     * Log a message with throwable information at WARN Level.
     *
     * @param message log message
     * @param throwable log a throwable information
     */
    override fun warn(message: String, throwable: Throwable?) {
        log.warn(message, throwable)
    }

    /**
     * Log a message with throwable information at ERROR Level.
     *
     * @param message log message
     * @param throwable log a throwable information
     */
    override fun error(message: String, throwable: Throwable?) {
        log.error(message, throwable)
    }
}