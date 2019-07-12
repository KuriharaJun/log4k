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

class MockProvider : Log4kServiceProvider {
    override fun initialize() = Unit

    override fun getLogFactory(): ILogFactory = object : ILogFactory {
        override fun getLogger(className: String): ILogger = object : ILogger {
            override val isTraceEnabled: Boolean
                get() = true
            override val isDebugEnabled: Boolean
                get() = true
            override val isInfoEnabled: Boolean
                get() = true
            override val isWarningEnabled: Boolean
                get() = true

            override fun trace(message: String, throwable: Throwable?) {
            }

            override fun debug(message: String, throwable: Throwable?) {
            }

            override fun info(message: String, throwable: Throwable?) {
            }

            override fun warn(message: String, throwable: Throwable?) {
            }

            override fun error(message: String, throwable: Throwable?) {
            }
        }
    }
}