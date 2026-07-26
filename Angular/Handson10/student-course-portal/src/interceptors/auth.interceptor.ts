import { HttpInterceptorFn } from '@angular/common/http';

export const authInterceptor: HttpInterceptorFn = (req, next) => {

  const modifiedReq = req.clone({
    setHeaders: {
      Authorization: 'Bearer sample-token'
    }
  });

  return next(modifiedReq);

};