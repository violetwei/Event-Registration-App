// Get Selenium and the drivers
var seleniumServer = require('selenium-server');
var chromedriver = require('chromedriver');
var geckodriver = require('geckodriver');

var config = {
    src_folders: [
        // Folders with tests
        'features'
    ],
    output_folder: 'reports', // Where to output the test reports
    selenium: {
        // Information for selenium, such as the location of the drivers ect.
        start_process: true,
        server_path: seleniumServer.path,
        port: 4444, // Standard selenium port
        cli_args: {
            'webdriver.chrome.driver': chromedriver.path,
            'webdriver.gecko.driver': geckodriver.path
        }
    },
    test_workers: {
        // This allows more then one browser to be opened and tested in at once
        enabled: true,
        workers: 'auto'
    },
    test_settings: {
        default: {
            screenshots: {
                enabled: false
            },
            globals: {
                // How long to wait (in milliseconds) before the test times out
                waitForConditionTimeout: 5000
            },
            desiredCapabilities: {
                // The default test
                browserName: 'chrome',
                javascriptEnabled: true,
                acceptSslCerts: true,
                nativeEvents: true
            }
        },
        // Here, we give each of the browsers we want to test in, and their driver configuration
        chrome: {
            desiredCapabilities: {
                browserName: 'chrome',
                javascriptEnabled: true,
                acceptSslCerts: true,
                nativeEvents: true,
                "chromeOptions": {
                    "args": ["headless", "disable-gpu"]
                }
            }
        },
        firefox: {
            desiredCapabilities: {
                browserName: 'firefox',
                javascriptEnabled: true,
                acceptSslCerts: true,
                nativeEvents: true
            }
        },
        safari: {
            desiredCapabilities: {
                browserName: 'safari',
                javascriptEnabled: true,
                acceptSslCerts: true,
                nativeEvents: true
            }
        }
    }
};

module.exports = config;