// Check if the browser supports PWA features
if ('serviceWorker' in navigator && 'Notification' in window) {
    // Register the service worker
    navigator.serviceWorker.register('service-worker.js').then(function(registration) {
        console.log('Service Worker registered with scope:', registration.scope);
    }).catch(function(error) {
        console.error('Service Worker registration failed:', error);
    });

    // Prompt the user to add to the home screen
    document.getElementById('addToHomeScreen').addEventListener('click', function() {
        if ('BeforeInstallPromptEvent' in window) {
            window.addEventListener('beforeinstallprompt', function(e) {
                e.prompt();
            });
        }
    });

    document.getElementById("goToNextPage").addEventListener("click", function() {
        // Redirect to another page when the button is clicked
        window.location.href = "another-page.html";
    });
}