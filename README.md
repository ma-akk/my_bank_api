# my_bank_api
study_project

1) Выпуск новой карты по счету ( curl -X POST -H "content-type: application/json" --data @src/main/resources/accountResponce.json localhost:8080/client/newcard ) \
2) Проcмотр списка карт ( curl -X GET -H "content-type: application/json" localhost:8080/client/"1111222233334444"/cards) \
3) Внесение вредств (don't work correct ) \
4) Проверка баланса (curl -X GET localhost:8080/cards/1/balance )
