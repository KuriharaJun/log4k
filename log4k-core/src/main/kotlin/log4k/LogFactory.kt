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

import java.util.*

/**
 * Provide logging class instance.
 */
object LogFactory {

    /**
     * Get logging service provider from class path.
     *
     * Detail information is seen at JavaDoc of [ServiceLoader]
     * [JavaDoc](https://docs.oracle.com/javase/jp/9/docs/api/java/util/ServiceLoader.html)
     *
     * @throws IllegalStateException ServiceProvider is not exists on classpath.
     * @return Logging service provider object.
     */
    private fun getServiceProvider(): Log4kServiceProvider {
        val loader = ServiceLoader.load(Log4kServiceProvider::class.java)
        val provider = loader.findFirst()
        if (provider.isEmpty)
            throw IllegalStateException("ServiceProvider is not found")
        else
            return provider.get()
    }

    private fun getLogFactory(): ILogFactory {
        val provider = getServiceProvider()
        provider.initialize()
        return provider.getLogFactory()
    }

    /**
     * Get logger instance by class name.
     *
     * @param className target class name.
     */
    fun getLogger(className: String): ILogger =
            getLogFactory().getLogger(className)

    /**
     * Get logger instance by class information.
     *
     * @param clazz target class information
     */
    fun getLogger(clazz: Class<out Any>): ILogger =
            getLogger(clazz.name)
}