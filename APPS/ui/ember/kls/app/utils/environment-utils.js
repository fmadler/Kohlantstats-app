import config from 'kohlantstats/config/environment';
export const { host, namespace } = config.scoreDS;
export const scoreDSConfig = config;
export function scoreDSConfig2() {
    return config.scoreDS;
}
