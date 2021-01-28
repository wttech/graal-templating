/* eslint-disable */
const path = require("path");

module.exports = {
  entry: './src/index.ts',
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader",
          options: {
            presets: ["@babel/preset-env"]
          }
        }
      },
      {
        test: /\.(ts|tsx)$/,
        exclude: /(node_modules|bower_components)/,
        loader: "ts-loader"
      },
    ]
  },
  resolve: {
    extensions: ["*", ".js", ".ts"]
  },
  output: {
    path: path.resolve(__dirname, "../resources/public/"),
    publicPath: "/",
    filename: "bundle.js"
  },
  devServer: {
    contentBase: path.resolve(__dirname, "../resources/public/"),
    port: 3000,
    publicPath: "/",
    historyApiFallback: {
      index: '/'
    },
    index: '',
    liveReload: false,
    writeToDisk: true
  }
};
