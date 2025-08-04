import http from 'k6/http';
import { sleep, check, group } from 'k6';

export const options = {
  stages: [
    { duration: '30s', target: 10 },
    { duration: '1m', target: 50 },
    { duration: '2m', target: 100 },
    { duration: '30s', target: 0 },
  ],
  thresholds: {
    http_req_duration: ['p(95)<600'],
    http_req_failed: ['rate<0.01'],
  },
};

export default function () {
  group('Escenario 1 - Consulta de recursos', function () {
    const res1 = http.get('https://test-api.k6.io/public/crocodiles/');
    check(res1, {
      'GET /crocodiles status 200': (r) => r.status === 200,
      'respuesta < 500ms': (r) => r.timings.duration < 500,
    });
    sleep(1);
  });

  group('Escenario 2 - Detalle de un recurso', function () {
    const res2 = http.get('https://test-api.k6.io/public/crocodiles/1/');
    check(res2, {
      'GET /crocodiles/1 status 200': (r) => r.status === 200,
      'detalle < 400ms': (r) => r.timings.duration < 400,
    });
    sleep(1);
  });

  group('Escenario 3 - Endpoint inexistente (error)', function () {
    const res3 = http.get('https://test-api.k6.io/public/404');
    check(res3, {
      'retorna 404': (r) => r.status === 404,
    });
    sleep(1);
  });
}
