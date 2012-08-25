log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
    }

    warn  'org.codehaus.griffon'

    error   'griffon.util',
           'griffon.core',
           'griffon.swt',
           'griffon.app'
}


platform.handler.macosx = 'griffon.swt.DefaultMacOSXPlatformHandler'
platform.handler.macosx64 = 'griffon.swt.DefaultMacOSXPlatformHandler'