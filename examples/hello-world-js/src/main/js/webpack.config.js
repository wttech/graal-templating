/* eslint-disable */
const path = require("path");

module.exports = {
  entry: './src/index.js',
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
    ]
  },
  resolve: {
    extensions: ["*", ".js"]
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
