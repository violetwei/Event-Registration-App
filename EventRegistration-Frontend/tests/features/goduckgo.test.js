module.exports = {
    'Demo test GODuckGO': function (client) {
        client
            .url('https://duckduckgo.com/')
            .waitForElementVisible('body', 1000)
            .assert.visible('input[type=text]')
            .setValue('input[type=text]', 'rembrandt van rijn')
            .pause(1000)
            .click('#search_button_homepage')
            .pause(1000)
            .assert.containsText('body', 'Rembrandt Harmenszoon van Rijn was a Dutch draughtsman')
            .end();
    }
};