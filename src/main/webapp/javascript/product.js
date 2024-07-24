function confirmPurchase(url) {
    if (confirm("구매하겠습니까?")) {
        location.href = url;
    }
}