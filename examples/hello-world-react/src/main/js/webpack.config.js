/* eslint-disable */
const path = require("path");

module.exports = {
  entry: './src/index.js',
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        use: {
          loader: "babel-loader",
          options: {
            presets: ["@babel/preset-env", "@babel/preset-react"]
          }
        }
      }
    ]
  },
  resolve: {
    extensions: ["*", ".js", ".jsx"],
    alias: {
      '@': path.join(__dirname, 'src'),
      react: path.resolve('./node_modules/react'),
      'react-dom': path.resolve('./node_modules/react-dom')
    }
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
