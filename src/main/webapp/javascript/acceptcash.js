$(document).ready(function() {
    $('.list-container form').on('submit', function(event) {
        event.preventDefault();

        var form = $(this);
        var action = form.attr('action');
        var requestData = form.serialize();
        var statusCell = form.closest('tr').find('.status');
        var isApproval = action.includes('approve-request');
        var confirmationMessage = isApproval ? '승인하겠습니까?' : '거절하시겠습니까?';
        
        if (confirm(confirmationMessage)) {
            $.ajax({
                url: action,
                method: form.attr('method'),
                data: requestData,
                success: function(response) {
                    console.log('서버 응답:', response);
                    if (response === 'success') {
                        if (isApproval) {
                            statusCell.text('승인');
                            var amount = parseFloat(form.find('input[name="amount"]').val());
                            var totalAmountElement = $('p:contains("총 충전 완료 금액:")');
                            var currentTotalAmount = parseFloat(totalAmountElement.text().match(/[\d,]+/)[0].replace(/,/g, ''));
                            var newTotalAmount = currentTotalAmount + amount;
                            totalAmountElement.text('총 충전 완료 금액: ' + newTotalAmount + ' 원');
                        } else {
                            statusCell.text('거절');
                        }
                    } else {
                        alert('요청 처리에 실패했습니다.');
                    }
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    console.error('AJAX 요청 실패:', textStatus, errorThrown);
                    alert('요청 처리에 실패했습니다.');
                }
            });
        }
    });
});
