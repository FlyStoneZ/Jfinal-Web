package org.webbuilder.core;

import java.io.IOException;
import java.io.Writer;

import org.beetl.core.ConsoleErrorHandler;
import org.beetl.core.Resource;
import org.beetl.core.ResourceLoader;
import org.beetl.core.exception.BeetlException;
import org.beetl.core.exception.ErrorInfo;

/**
 * customer renderException error
 * 
 * @author Stone Date: 2016年7月28日 下午9:40:07 Email:shentong33@hotmail.com
 */
public class ViewRenderException extends ConsoleErrorHandler {

	private static String mark = "########################## Error Info ##########################";

	@Override
	public void processExcption(BeetlException ex, Writer writer) {
		// sync ex to prevent print exception
		// synchronized (ex) {
		// super.processExcption(ex, writer);
		// throw new RuntimeException(ex);
		// }

		synchronized (ex) {
			ErrorInfo error = new ErrorInfo(ex);

			if (error.getErrorCode().equals(BeetlException.CLIENT_IO_ERROR_ERROR)) {
				// 不输出详细提示信息
				if (!ex.gt.getConf().isIgnoreClientIOError()) {
					println(writer, "客户端IO异常:" + getResourceName(ex.resourceId) + ":" + error.getMsg());
					if (ex.getCause() != null) {
						this.printThrowable(writer, ex.getCause());
					}
				}

			}

			int line = error.getErrorTokenLine();

			StringBuilder sb = new StringBuilder(mark).append(ex.cr).append(this.getDateTime()).append(":")
					.append(error.getType()).append(":").append(error.getErrorTokenText()).append(" 位于").append(line)
					.append("行").append(" 资源:").append(getResourceName(ex.resourceId));

			if (error.getErrorCode().equals(BeetlException.TEMPLATE_LOAD_ERROR)) {
				if (error.getMsg() != null)
					sb.append(error.getMsg());
				println(writer, sb.toString());
			}

			println(writer, sb.toString());
			if (ex.getMessage() != null) {
				println(writer, ex.getMessage());
			}

			ResourceLoader resLoader = ex.gt.getResourceLoader();
			// 潜在问题，此时可能得到是一个新的模板，不过可能性很小，忽略！

			String content = null;
			;
			try {
				Resource res = resLoader.getResource(ex.resourceId);
				// 显示前后三行的内容
				int[] range = this.getRange(line);
				content = res.getContent(range[0], range[1]);
				if (content != null) {
					String[] strs = content.split(ex.cr);
					int lineNumber = range[0];
					for (int i = 0; i < strs.length; i++) {
						print(writer, "" + lineNumber);
						print(writer, "|");
						println(writer, strs[i]);
						lineNumber++;
					}
					println(null, ex.cr + mark);
				}
			} catch (IOException e) {

				// ingore

			}

			if (error.hasCallStack()) {
				println(writer, "  ========================");
				println(writer, "  调用栈:");
				for (int i = 0; i < error.getResourceCallStack().size(); i++) {
					println(writer,
							"  " + error.getResourceCallStack().get(i) + " 行：" + error.getTokenCallStack().get(i).line);
				}
			}

			printCause(error, writer);
			try {
				writer.flush();
			} catch (IOException e) {

			}
			throw new RuntimeException(ex);
		}
	}
}
