
export default {
  bootstrap: () => import('./main.server.mjs').then(m => m.default),
  inlineCriticalCss: true,
  baseHref: '/',
  locale: undefined,
  routes: [
  {
    "renderMode": 2,
    "route": "/"
  }
],
  entryPointToBrowserMapping: undefined,
  assets: {
    'index.csr.html': {size: 262, hash: 'e948064aa20b70c8b0cc1b7f700d4c48b25fbc22100ef3d3a60f66c46f3e8870', text: () => import('./assets-chunks/index_csr_html.mjs').then(m => m.default)},
    'index.server.html': {size: 775, hash: 'e47ead0dc41c9563c2d4e5f0f373b2f60d48aa8d79eacc12cfa1c52c008690b7', text: () => import('./assets-chunks/index_server_html.mjs').then(m => m.default)},
    'index.html': {size: 21262, hash: 'ff62c2b21711fc32fa818d022bc7c67b3ea86b0d6ab09eb99fe161fca363a03f', text: () => import('./assets-chunks/index_html.mjs').then(m => m.default)},
    'styles-5INURTSO.css': {size: 0, hash: 'menYUTfbRu8', text: () => import('./assets-chunks/styles-5INURTSO_css.mjs').then(m => m.default)}
  },
};
