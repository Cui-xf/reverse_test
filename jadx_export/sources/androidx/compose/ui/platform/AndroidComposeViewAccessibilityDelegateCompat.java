package androidx.compose.ui.platform;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.ArraySet;
import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.IntSet;
import androidx.collection.IntSetKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AccessibilityIterators;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.text.platform.URLSpanCache;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
@Metadata(d1 = {"\u0000è\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 ú\u00012\u00020\u0001:\u0010ø\u0001ù\u0001ú\u0001û\u0001ü\u0001ý\u0001þ\u0001ÿ\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010p\u001a\u00020!2\u0006\u0010q\u001a\u00020\u00122\u0006\u0010r\u001a\u00020*2\u0006\u0010s\u001a\u00020\u00062\b\u0010t\u001a\u0004\u0018\u00010uH\u0002J\u0010\u0010v\u001a\u00020w2\u0006\u0010x\u001a\u00020%H\u0002J\u0010\u0010y\u001a\u00020!H\u0080@¢\u0006\u0004\bz\u0010{J;\u0010|\u001a\u00020\u00142\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010}\u001a\u00020\u00142\u0006\u0010~\u001a\u00020\u00122\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J-\u0010|\u001a\u00020\u00142\u0006\u0010}\u001a\u00020\u00142\u0006\u0010~\u001a\u00020\u00122\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\t\u0010\u0085\u0001\u001a\u00020!H\u0002J\u0011\u0010\u0086\u0001\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u0012H\u0002J\u001a\u0010\u0087\u0001\u001a\u00020N2\u0006\u0010q\u001a\u00020\u00122\u0007\u0010\u0088\u0001\u001a\u00020\u0012H\u0003J\u0013\u0010\u0089\u0001\u001a\u0004\u0018\u00010*2\u0006\u0010q\u001a\u00020\u0012H\u0002J\u0014\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002JC\u0010\u008c\u0001\u001a\u00020N2\u0006\u0010q\u001a\u00020\u00122\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00122\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0003\u0010\u0091\u0001J\u0019\u0010\u0092\u0001\u001a\u00020\u00142\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0000¢\u0006\u0003\b\u0095\u0001JF\u0010\u0096\u0001\u001a\u00020!2\b\u0010\u0097\u0001\u001a\u00030\u008b\u00012\u001b\u0010\u0098\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u008b\u00010\u0099\u0001j\n\u0012\u0005\u0012\u00030\u008b\u0001`\u009a\u00012\u0014\u0010\u009b\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008b\u00010,0WH\u0002J\u0014\u0010\u009c\u0001\u001a\u00030\u009d\u00012\b\u0010\u009e\u0001\u001a\u00030\u009f\u0001H\u0016J\u0012\u0010 \u0001\u001a\u00020\u00122\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010¡\u0001\u001a\u00020\u00122\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010¢\u0001\u001a\u00020\u00142\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002J\u0014\u0010£\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002J\u0015\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u00012\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002J\u0016\u0010¦\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010x\u001a\u0005\u0018\u00010\u008b\u0001H\u0002J \u0010§\u0001\u001a\u0005\u0018\u00010¨\u00012\t\u0010x\u001a\u0005\u0018\u00010\u008b\u00012\u0007\u0010©\u0001\u001a\u00020\u0012H\u0002J#\u0010ª\u0001\u001a\u00020\u00122\b\u0010«\u0001\u001a\u00030¬\u00012\b\u0010\u00ad\u0001\u001a\u00030¬\u0001H\u0001¢\u0006\u0003\b®\u0001J\u0011\u0010¯\u0001\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u0012H\u0002J\u0012\u0010°\u0001\u001a\u00020\u00142\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010±\u0001\u001a\u00020\u00142\u0007\u0010x\u001a\u00030\u008b\u0001H\u0002J\u0012\u0010²\u0001\u001a\u00020!2\u0007\u0010³\u0001\u001a\u00020iH\u0002J\u0018\u0010´\u0001\u001a\u00020!2\u0007\u0010³\u0001\u001a\u00020iH\u0000¢\u0006\u0003\bµ\u0001J\u000f\u0010¶\u0001\u001a\u00020!H\u0000¢\u0006\u0003\b·\u0001J$\u0010¸\u0001\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u00122\u0007\u0010¹\u0001\u001a\u00020\u00122\b\u0010t\u001a\u0004\u0018\u00010uH\u0002J#\u0010º\u0001\u001a\u00020!2\u0006\u0010q\u001a\u00020\u00122\u0006\u0010r\u001a\u00020*2\b\u0010»\u0001\u001a\u00030\u008b\u0001H\u0002J!\u0010¼\u0001\u001a\u00020\u00142\u0007\u0010½\u0001\u001a\u00020\u00122\r\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020b0/H\u0002J\u0011\u0010¿\u0001\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u0012H\u0002J\u0012\u0010À\u0001\u001a\u00020!2\u0007\u0010Á\u0001\u001a\u00020bH\u0002J'\u0010Â\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u008b\u00010Ã\u0001j\n\u0012\u0005\u0012\u00030\u008b\u0001`Ä\u00012\u0007\u0010Å\u0001\u001a\u00020\u0014H\u0082\bJ\u0012\u0010Æ\u0001\u001a\u00020\u00122\u0007\u0010½\u0001\u001a\u00020\u0012H\u0002J\u001c\u0010Ç\u0001\u001a\u00020!2\b\u0010È\u0001\u001a\u00030\u008b\u00012\u0007\u0010É\u0001\u001a\u00020]H\u0002J\u0012\u0010Ê\u0001\u001a\u00020\u00142\u0007\u0010\u0093\u0001\u001a\u00020NH\u0002J@\u0010Ë\u0001\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u00122\u0007\u0010\u0088\u0001\u001a\u00020\u00122\u000b\b\u0002\u0010Ì\u0001\u001a\u0004\u0018\u00010\u00122\u0011\b\u0002\u0010Í\u0001\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010/H\u0002¢\u0006\u0003\u0010Î\u0001J&\u0010Ï\u0001\u001a\u00020!2\u0007\u0010Ð\u0001\u001a\u00020\u00122\u0007\u0010Ì\u0001\u001a\u00020\u00122\t\u0010Ñ\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010Ò\u0001\u001a\u00020!2\u0007\u0010Ð\u0001\u001a\u00020\u0012H\u0002J\u0018\u0010Ó\u0001\u001a\u00020!2\r\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\u001b\u0010Õ\u0001\u001a\u00020!2\u0007\u0010³\u0001\u001a\u00020i2\u0007\u0010Ö\u0001\u001a\u00020UH\u0002J\u0012\u0010×\u0001\u001a\u00020!2\u0007\u0010³\u0001\u001a\u00020iH\u0002J-\u0010Ø\u0001\u001a\u00020\u00142\u0007\u0010x\u001a\u00030\u008b\u00012\u0007\u0010Ù\u0001\u001a\u00020\u00122\u0007\u0010Ú\u0001\u001a\u00020\u00122\u0007\u0010Û\u0001\u001a\u00020\u0014H\u0002J\u001a\u0010Ü\u0001\u001a\u00020!2\u0007\u0010x\u001a\u00030\u008b\u00012\u0006\u0010r\u001a\u00020*H\u0002J\u001a\u0010Ý\u0001\u001a\u00020!2\u0007\u0010x\u001a\u00030\u008b\u00012\u0006\u0010r\u001a\u00020*H\u0002J\u001a\u0010Þ\u0001\u001a\u00020!2\u0007\u0010x\u001a\u00030\u008b\u00012\u0006\u0010r\u001a\u00020*H\u0002J\u001a\u0010ß\u0001\u001a\u00020!2\u0007\u0010x\u001a\u00030\u008b\u00012\u0006\u0010r\u001a\u00020*H\u0002J\t\u0010à\u0001\u001a\u00020!H\u0002JN\u0010á\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010,2\u0007\u0010Å\u0001\u001a\u00020\u00142\u001b\u0010â\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u008b\u00010\u0099\u0001j\n\u0012\u0005\u0012\u00030\u008b\u0001`\u009a\u00012\u0016\b\u0002\u0010ã\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008b\u00010,0WH\u0002J)\u0010ä\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010,2\u0007\u0010Å\u0001\u001a\u00020\u00142\u000e\u0010å\u0001\u001a\t\u0012\u0005\u0012\u00030\u008b\u00010,H\u0002J\"\u0010æ\u0001\u001a\u0005\u0018\u00010ç\u00012\n\u0010è\u0001\u001a\u0005\u0018\u00010\u008b\u00012\b\u0010é\u0001\u001a\u00030ê\u0001H\u0002J-\u0010ë\u0001\u001a\u00020\u00142\u0007\u0010x\u001a\u00030\u008b\u00012\u0007\u0010©\u0001\u001a\u00020\u00122\u0007\u0010ì\u0001\u001a\u00020\u00142\u0007\u0010í\u0001\u001a\u00020\u0014H\u0002J4\u0010î\u0001\u001a\u0005\u0018\u0001Hï\u0001\"\t\b\u0000\u0010ï\u0001*\u00020\u001e2\n\u0010\u0090\u0001\u001a\u0005\u0018\u0001Hï\u00012\t\b\u0001\u0010ð\u0001\u001a\u00020\u0012H\u0002¢\u0006\u0003\u0010ñ\u0001J\u0011\u0010ò\u0001\u001a\u00020!2\u0006\u0010q\u001a\u00020\u0012H\u0002J\t\u0010ó\u0001\u001a\u00020!H\u0002J\u0011\u0010ô\u0001\u001a\u0005\u0018\u00010¥\u0001*\u00030õ\u0001H\u0002J\u0011\u0010ö\u0001\u001a\u0005\u0018\u00010÷\u0001*\u00030¥\u0001H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R2\u0010+\u001a&\u0012\f\u0012\n .*\u0004\u0018\u00010-0- .*\u0012\u0012\f\u0012\n .*\u0004\u0018\u00010-0-\u0018\u00010/0,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R$\u00105\u001a\u00020\u00128\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020=X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020=X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010?\"\u0004\bD\u0010AR\u0014\u0010E\u001a\u00020\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0017R\u0014\u0010G\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0017R\u001a\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0I0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010J\u001a\u00060KR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010L\u001a\u000e\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u00140M8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bO\u00107\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u000e\u0010T\u001a\u00020UX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\b\u0012\u0004\u0012\u00020X0WX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010[\u001a\b\u0012\u0004\u0012\u00020X0WX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0WX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010_\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0004\n\u0002\u0010`R\u001a\u0010a\u001a\u000e\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020!0MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010c\u001a\b\u0012\u0004\u0012\u00020b0,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010g\u001a\b\u0012\u0004\u0012\u00020i0hX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020kX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020mX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bn\u0010o\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0080\u0002"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "ExtraDataTestTraversalAfterVal", "", "getExtraDataTestTraversalAfterVal$ui_release", "()Ljava/lang/String;", "ExtraDataTestTraversalBeforeVal", "getExtraDataTestTraversalBeforeVal$ui_release", "SendRecurringAccessibilityEventsIntervalMillis", "", "getSendRecurringAccessibilityEventsIntervalMillis$ui_release", "()J", "setSendRecurringAccessibilityEventsIntervalMillis$ui_release", "(J)V", "accessibilityCursorPosition", "", "value", "", "accessibilityForceEnabledForTesting", "getAccessibilityForceEnabledForTesting$ui_release", "()Z", "setAccessibilityForceEnabledForTesting$ui_release", "(Z)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "checkingForSemanticsChanges", "currentSemanticsNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes", "()Landroidx/collection/IntObjectMap;", "currentSemanticsNodesInvalidated", "currentlyFocusedANI", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "enabledServices", "", "Landroid/accessibilityservice/AccessibilityServiceInfo;", "kotlin.jvm.PlatformType", "", "enabledStateListener", "Landroid/view/accessibility/AccessibilityManager$AccessibilityStateChangeListener;", "focusedVirtualViewId", "handler", "Landroid/os/Handler;", "hoveredVirtualViewId", "getHoveredVirtualViewId$ui_release$annotations", "()V", "getHoveredVirtualViewId$ui_release", "()I", "setHoveredVirtualViewId$ui_release", "(I)V", "idToAfterMap", "Landroidx/collection/MutableIntIntMap;", "getIdToAfterMap$ui_release", "()Landroidx/collection/MutableIntIntMap;", "setIdToAfterMap$ui_release", "(Landroidx/collection/MutableIntIntMap;)V", "idToBeforeMap", "getIdToBeforeMap$ui_release", "setIdToBeforeMap$ui_release", "isEnabled", "isEnabled$ui_release", "isTouchExplorationEnabled", "labelToActionId", "Landroidx/collection/MutableObjectIntMap;", "nodeProvider", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "onSendAccessibilityEvent", "Lkotlin/Function1;", "Landroid/view/accessibility/AccessibilityEvent;", "getOnSendAccessibilityEvent$ui_release$annotations", "getOnSendAccessibilityEvent$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnSendAccessibilityEvent$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "paneDisplayed", "Landroidx/collection/MutableIntSet;", "pendingHorizontalScrollEvents", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "pendingVerticalScrollEvents", "previousSemanticsNodes", "Landroidx/compose/ui/platform/SemanticsNodeCopy;", "previousSemanticsRoot", "previousTraversedNode", "Ljava/lang/Integer;", "scheduleScrollEventIfNeededLambda", "Landroidx/compose/ui/platform/ScrollObservationScope;", "scrollObservationScopes", "semanticsChangeChecker", "Ljava/lang/Runnable;", "sendingFocusAffectingEvent", "subtreeChangedLayoutNodes", "Landroidx/collection/ArraySet;", "Landroidx/compose/ui/node/LayoutNode;", "touchExplorationStateListener", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "urlSpanCache", "Landroidx/compose/ui/text/platform/URLSpanCache;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "extraDataKey", "arguments", "Landroid/os/Bundle;", "boundsInScreen", "Landroid/graphics/Rect;", "node", "boundsUpdatesEventLoop", "boundsUpdatesEventLoop$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canScroll", "vertical", "direction", "position", "Landroidx/compose/ui/geometry/Offset;", "canScroll-moWRBKg", "(Landroidx/collection/IntObjectMap;ZIJ)Z", "canScroll-0AR0LA0$ui_release", "(ZIJ)Z", "checkForSemanticsChanges", "clearAccessibilityFocus", "createEvent", "eventType", "createNodeInfo", "createStateDescriptionForTextField", "Landroidx/compose/ui/semantics/SemanticsNode;", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/CharSequence;)Landroid/view/accessibility/AccessibilityEvent;", "dispatchHoverEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "dispatchHoverEvent$ui_release", "geometryDepthFirstSearch", "currNode", "geometryList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "containerMapToChildren", "getAccessibilityNodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "host", "Landroid/view/View;", "getAccessibilitySelectionEnd", "getAccessibilitySelectionStart", "getInfoIsCheckable", "getInfoStateDescriptionOrNull", "getInfoText", "Landroidx/compose/ui/text/AnnotatedString;", "getIterableTextForAccessibility", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "granularity", "hitTestSemanticsAt", "x", "", "y", "hitTestSemanticsAt$ui_release", "isAccessibilityFocused", "isAccessibilitySelectionExtendable", "isScreenReaderFocusable", "notifySubtreeAccessibilityStateChangedIfNeeded", "layoutNode", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "performActionHelper", "action", "populateAccessibilityNodeInfoProperties", "semanticsNode", "registerScrollingId", "id", "oldScrollObservationScopes", "requestAccessibilityFocus", "scheduleScrollEventIfNeeded", "scrollObservationScope", "semanticComparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "layoutIsRtl", "semanticsNodeIdToAccessibilityVirtualNodeId", "sendAccessibilitySemanticsStructureChangeEvents", "newNode", "oldNode", "sendEvent", "sendEventForVirtualView", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendPendingTextTraversedAtGranularityEvent", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "sendTypeViewScrolledAccessibilityEvent", "setAccessibilitySelection", "start", "end", "traversalMode", "setContentInvalid", "setIsCheckable", "setStateDescription", "setText", "setTraversalValues", "sortByGeometryGroupings", "parentListToSort", "containerChildrenMapping", "subtreeSortedByGeometryGrouping", "listToSort", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "Landroidx/compose/ui/geometry/Rect;", "traverseAtGranularity", "forward", "extendSelection", "trimToSize", "T", "size", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "updateHoveredVirtualView", "updateSemanticsNodesCopyAndPanes", "getTextForTextField", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "toSpannableString", "Landroid/text/SpannableString;", "Api24Impl", "Api29Impl", "Companion", "ComposeAccessibilityNodeProvider", "LtrBoundsComparator", "PendingTextTraversedEvent", "RtlBoundsComparator", "TopBottomBoundsComparator", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    public static final String ClassName = "android.view.View";
    public static final String ExtraDataIdKey = "androidx.compose.ui.semantics.id";
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final String TextClassName = "android.widget.TextView";
    public static final String TextFieldClassName = "android.widget.EditText";
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private final String ExtraDataTestTraversalAfterVal;
    private final String ExtraDataTestTraversalBeforeVal;
    private long SendRecurringAccessibilityEventsIntervalMillis;
    private int accessibilityCursorPosition;
    private boolean accessibilityForceEnabledForTesting;
    private final android.view.accessibility.AccessibilityManager accessibilityManager;
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    private final Channel<Unit> boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;
    private IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private AccessibilityNodeInfoCompat currentlyFocusedANI;
    private List<AccessibilityServiceInfo> enabledServices;
    private final AccessibilityManager.AccessibilityStateChangeListener enabledStateListener;
    private int focusedVirtualViewId;
    private final Handler handler;
    private MutableIntIntMap idToAfterMap;
    private MutableIntIntMap idToBeforeMap;
    private SparseArrayCompat<MutableObjectIntMap<CharSequence>> labelToActionId;
    private ComposeAccessibilityNodeProvider nodeProvider;
    private MutableIntSet paneDisplayed;
    private final MutableIntObjectMap<ScrollAxisRange> pendingHorizontalScrollEvents;
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    private final MutableIntObjectMap<ScrollAxisRange> pendingVerticalScrollEvents;
    private MutableIntObjectMap<SemanticsNodeCopy> previousSemanticsNodes;
    private SemanticsNodeCopy previousSemanticsRoot;
    private Integer previousTraversedNode;
    private final Function1<ScrollObservationScope, Unit> scheduleScrollEventIfNeededLambda;
    private final List<ScrollObservationScope> scrollObservationScopes;
    private final Runnable semanticsChangeChecker;
    private boolean sendingFocusAffectingEvent;
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateListener;
    private final URLSpanCache urlSpanCache;
    private final AndroidComposeView view;
    public static final int $stable = 8;
    private static final IntList AccessibilityActionsResourceIds = IntListKt.intListOf(R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31);
    private int hoveredVirtualViewId = Integer.MIN_VALUE;
    private Function1<? super AccessibilityEvent, Boolean> onSendAccessibilityEvent = new Function1<AccessibilityEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(AccessibilityEvent it) {
            return Boolean.valueOf(this.this$0.getView().getParent().requestSendAccessibilityEvent(this.this$0.getView(), it));
        }
    };

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getHoveredVirtualViewId$ui_release$annotations() {
    }

    public static /* synthetic */ void getOnSendAccessibilityEvent$ui_release$annotations() {
    }

    public final AndroidComposeView getView() {
        return this.view;
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView view) {
        this.view = view;
        Object systemService = this.view.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
        this.SendRecurringAccessibilityEventsIntervalMillis = 100L;
        this.enabledStateListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z) {
                AndroidComposeViewAccessibilityDelegateCompat.enabledStateListener$lambda$0(this.f$0, z);
            }
        };
        this.touchExplorationStateListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda2
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.f$0;
                androidComposeViewAccessibilityDelegateCompat.enabledServices = androidComposeViewAccessibilityDelegateCompat.accessibilityManager.getEnabledAccessibilityServiceList(-1);
            }
        };
        this.enabledServices = this.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new ComposeAccessibilityNodeProvider();
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.pendingHorizontalScrollEvents = new MutableIntObjectMap<>(0, 1, null);
        this.pendingVerticalScrollEvents = new MutableIntObjectMap<>(0, 1, null);
        this.actionIdToLabel = new SparseArrayCompat<>(0, 1, null);
        this.labelToActionId = new SparseArrayCompat<>(0, 1, null);
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>(0, 1, null);
        this.boundsUpdateChannel = ChannelKt.Channel$default(1, null, null, 6, null);
        this.currentSemanticsNodesInvalidated = true;
        this.currentSemanticsNodes = IntObjectMapKt.intObjectMapOf();
        this.paneDisplayed = new MutableIntSet(0, 1, null);
        this.idToBeforeMap = new MutableIntIntMap(0, 1, null);
        this.idToAfterMap = new MutableIntIntMap(0, 1, null);
        this.ExtraDataTestTraversalBeforeVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.ExtraDataTestTraversalAfterVal = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.urlSpanCache = new URLSpanCache();
        this.previousSemanticsNodes = IntObjectMapKt.mutableIntObjectMapOf();
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), IntObjectMapKt.intObjectMapOf());
        this.view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
                android.view.accessibility.AccessibilityManager $this$onViewAttachedToWindow_u24lambda_u240 = AndroidComposeViewAccessibilityDelegateCompat.this.accessibilityManager;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
                $this$onViewAttachedToWindow_u24lambda_u240.addAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
                $this$onViewAttachedToWindow_u24lambda_u240.addTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                AndroidComposeViewAccessibilityDelegateCompat.this.handler.removeCallbacks(AndroidComposeViewAccessibilityDelegateCompat.this.semanticsChangeChecker);
                android.view.accessibility.AccessibilityManager $this$onViewDetachedFromWindow_u24lambda_u241 = AndroidComposeViewAccessibilityDelegateCompat.this.accessibilityManager;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
                $this$onViewDetachedFromWindow_u24lambda_u241.removeAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
                $this$onViewDetachedFromWindow_u24lambda_u241.removeTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
            }
        });
        this.semanticsChangeChecker = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker$lambda$60(this.f$0);
            }
        };
        this.scrollObservationScopes = new ArrayList();
        this.scheduleScrollEventIfNeededLambda = new Function1<ScrollObservationScope, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeededLambda$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScrollObservationScope scrollObservationScope) {
                invoke2(scrollObservationScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ScrollObservationScope it) {
                this.this$0.scheduleScrollEventIfNeeded(it);
            }
        };
    }

    /* renamed from: getHoveredVirtualViewId$ui_release, reason: from getter */
    public final int getHoveredVirtualViewId() {
        return this.hoveredVirtualViewId;
    }

    public final void setHoveredVirtualViewId$ui_release(int i) {
        this.hoveredVirtualViewId = i;
    }

    public final Function1<AccessibilityEvent, Boolean> getOnSendAccessibilityEvent$ui_release() {
        return this.onSendAccessibilityEvent;
    }

    public final void setOnSendAccessibilityEvent$ui_release(Function1<? super AccessibilityEvent, Boolean> function1) {
        this.onSendAccessibilityEvent = function1;
    }

    /* renamed from: getAccessibilityForceEnabledForTesting$ui_release, reason: from getter */
    public final boolean getAccessibilityForceEnabledForTesting() {
        return this.accessibilityForceEnabledForTesting;
    }

    public final void setAccessibilityForceEnabledForTesting$ui_release(boolean value) {
        this.accessibilityForceEnabledForTesting = value;
        this.currentSemanticsNodesInvalidated = true;
    }

    /* renamed from: getSendRecurringAccessibilityEventsIntervalMillis$ui_release, reason: from getter */
    public final long getSendRecurringAccessibilityEventsIntervalMillis() {
        return this.SendRecurringAccessibilityEventsIntervalMillis;
    }

    public final void setSendRecurringAccessibilityEventsIntervalMillis$ui_release(long j) {
        this.SendRecurringAccessibilityEventsIntervalMillis = j;
    }

    static final void enabledStateListener$lambda$0(AndroidComposeViewAccessibilityDelegateCompat this$0, boolean enabled) {
        List<AccessibilityServiceInfo> listEmptyList;
        if (enabled) {
            listEmptyList = this$0.accessibilityManager.getEnabledAccessibilityServiceList(-1);
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        this$0.enabledServices = listEmptyList;
    }

    public final boolean isEnabled$ui_release() {
        return this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && !this.enabledServices.isEmpty());
    }

    private final boolean isTouchExplorationEnabled() {
        return this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled());
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getAction", "()I", "getFromIndex", "getGranularity", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getToIndex", "getTraverseTime", "()J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode node, int action, int granularity, int fromIndex, int toIndex, long traverseTime) {
            this.node = node;
            this.action = action;
            this.granularity = granularity;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
            this.traverseTime = traverseTime;
        }

        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IntObjectMap<SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            Trace.beginSection("generateCurrentSemanticsNodes");
            try {
                IntObjectMap<SemanticsNodeWithAdjustedBounds> allUncoveredSemanticsNodesToIntObjectMap = SemanticsUtils_androidKt.getAllUncoveredSemanticsNodesToIntObjectMap(this.view.getSemanticsOwner());
                Trace.endSection();
                this.currentSemanticsNodes = allUncoveredSemanticsNodesToIntObjectMap;
                if (isEnabled$ui_release()) {
                    Trace.beginSection("setTraversalValues");
                    try {
                        setTraversalValues();
                        Unit unit = Unit.INSTANCE;
                    } finally {
                    }
                }
            } finally {
            }
        }
        return this.currentSemanticsNodes;
    }

    /* renamed from: getIdToBeforeMap$ui_release, reason: from getter */
    public final MutableIntIntMap getIdToBeforeMap() {
        return this.idToBeforeMap;
    }

    public final void setIdToBeforeMap$ui_release(MutableIntIntMap mutableIntIntMap) {
        this.idToBeforeMap = mutableIntIntMap;
    }

    /* renamed from: getIdToAfterMap$ui_release, reason: from getter */
    public final MutableIntIntMap getIdToAfterMap() {
        return this.idToAfterMap;
    }

    public final void setIdToAfterMap$ui_release(MutableIntIntMap mutableIntIntMap) {
        this.idToAfterMap = mutableIntIntMap;
    }

    /* renamed from: getExtraDataTestTraversalBeforeVal$ui_release, reason: from getter */
    public final String getExtraDataTestTraversalBeforeVal() {
        return this.ExtraDataTestTraversalBeforeVal;
    }

    /* renamed from: getExtraDataTestTraversalAfterVal$ui_release, reason: from getter */
    public final String getExtraDataTestTraversalAfterVal() {
        return this.ExtraDataTestTraversalAfterVal;
    }

    /* renamed from: canScroll-0AR0LA0$ui_release, reason: not valid java name */
    public final boolean m5870canScroll0AR0LA0$ui_release(boolean vertical, int direction, long position) {
        if (!Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            return false;
        }
        return m5869canScrollmoWRBKg(getCurrentSemanticsNodes(), vertical, direction, position);
    }

    /* renamed from: canScroll-moWRBKg, reason: not valid java name */
    private final boolean m5869canScrollmoWRBKg(IntObjectMap<SemanticsNodeWithAdjustedBounds> currentSemanticsNodes, boolean vertical, int direction, long position) {
        SemanticsPropertyKey scrollRangeProperty;
        char c;
        ScrollAxisRange scrollRange;
        if (Offset.m3942equalsimpl0(position, Offset.INSTANCE.m3960getUnspecifiedF1C5BW0()) || !Offset.m3948isValidimpl(position)) {
            return false;
        }
        if (vertical) {
            scrollRangeProperty = SemanticsProperties.INSTANCE.getVerticalScrollAxisRange();
        } else {
            if (vertical) {
                throw new NoWhenBranchMatchedException();
            }
            scrollRangeProperty = SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange();
        }
        boolean foundNode = false;
        IntObjectMap this_$iv = currentSemanticsNodes;
        Object[] v$iv = this_$iv.values;
        long[] m$iv$iv = this_$iv.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                boolean foundNode2 = foundNode;
                IntObjectMap this_$iv2 = this_$iv;
                long $this$maskEmptyOrDeleted$iv$iv$iv = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv == -9187201950435737472L) {
                    foundNode = foundNode2;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    for (int j$iv$iv = 0; j$iv$iv < bitCount$iv$iv; j$iv$iv++) {
                        long value$iv$iv$iv = slot$iv$iv & 255;
                        int $i$f$isFull = value$iv$iv$iv < 128 ? 1 : 0;
                        if ($i$f$isFull == 0) {
                            c = '\b';
                        } else {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            SemanticsNodeWithAdjustedBounds node = (SemanticsNodeWithAdjustedBounds) v$iv[index$iv$iv];
                            c = '\b';
                            if (RectHelper_androidKt.toComposeRect(node.getAdjustedBounds()).m3971containsk4lQ0M(position) && (scrollRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(node.getSemanticsNode().getUnmergedConfig(), scrollRangeProperty)) != null) {
                                int actualDirection = scrollRange.getReverseScrolling() ? -direction : direction;
                                if (direction == 0 && scrollRange.getReverseScrolling()) {
                                    actualDirection = -1;
                                }
                                if (actualDirection < 0) {
                                    if (scrollRange.getValue().invoke().floatValue() > 0.0f) {
                                        foundNode2 = true;
                                    }
                                } else if (scrollRange.getValue().invoke().floatValue() < scrollRange.getMaxValue().invoke().floatValue()) {
                                    foundNode2 = true;
                                }
                            }
                        }
                        slot$iv$iv >>= c;
                    }
                    if (bitCount$iv$iv != 8) {
                        return foundNode2;
                    }
                    foundNode = foundNode2;
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                this_$iv = this_$iv2;
            }
        }
        return foundNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final AccessibilityNodeInfoCompat createNodeInfo(int virtualViewId) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycleRegistry;
        Trace.beginSection("checkIfDestroyed");
        try {
            AndroidComposeView.ViewTreeOwners viewTreeOwners = this.view.getViewTreeOwners();
            if (((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycleRegistry = lifecycleOwner.getLifecycleRegistry()) == null) ? null : lifecycleRegistry.getState()) == Lifecycle.State.DESTROYED) {
                return null;
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("createAccessibilityNodeInfoObject");
            try {
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain();
                Trace.endSection();
                Trace.beginSection("calculateNodeWithAdjustedBounds");
                try {
                    SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
                    if (semanticsNodeWithAdjustedBounds == null) {
                        return null;
                    }
                    SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode();
                    Trace.beginSection("setParentForAccessibility");
                    try {
                        if (virtualViewId == -1) {
                            ViewParent parentForAccessibility = this.view.getParentForAccessibility();
                            accessibilityNodeInfoCompatObtain.setParent(parentForAccessibility instanceof View ? (View) parentForAccessibility : null);
                        } else {
                            SemanticsNode parent = semanticsNode.getParent();
                            Integer numValueOf = parent != null ? Integer.valueOf(parent.getId()) : null;
                            if (numValueOf != null) {
                                int iIntValue = numValueOf.intValue();
                                if (iIntValue == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
                                    iIntValue = -1;
                                }
                                accessibilityNodeInfoCompatObtain.setParent(this.view, iIntValue);
                            } else {
                                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("semanticsNode " + virtualViewId + " has null parent");
                                throw new KotlinNothingValueException();
                            }
                        }
                        Unit unit2 = Unit.INSTANCE;
                        Trace.endSection();
                        accessibilityNodeInfoCompatObtain.setSource(this.view, virtualViewId);
                        Trace.beginSection("setBoundsInScreen");
                        try {
                            accessibilityNodeInfoCompatObtain.setBoundsInScreen(boundsInScreen(semanticsNodeWithAdjustedBounds));
                            Unit unit3 = Unit.INSTANCE;
                            Trace.endSection();
                            Trace.beginSection("populateAccessibilityNodeInfoProperties");
                            try {
                                populateAccessibilityNodeInfoProperties(virtualViewId, accessibilityNodeInfoCompatObtain, semanticsNode);
                                Unit unit4 = Unit.INSTANCE;
                                return accessibilityNodeInfoCompatObtain;
                            } finally {
                            }
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect boundsInScreen(SemanticsNodeWithAdjustedBounds node) {
        Rect boundsInRoot = node.getAdjustedBounds();
        long topLeftInScreen = this.view.mo5487localToScreenMKHz9U(OffsetKt.Offset(boundsInRoot.left, boundsInRoot.top));
        long bottomRightInScreen = this.view.mo5487localToScreenMKHz9U(OffsetKt.Offset(boundsInRoot.right, boundsInRoot.bottom));
        return new Rect((int) Math.floor(Offset.m3945getXimpl(topLeftInScreen)), (int) Math.floor(Offset.m3946getYimpl(topLeftInScreen)), (int) Math.ceil(Offset.m3945getXimpl(bottomRightInScreen)), (int) Math.ceil(Offset.m3946getYimpl(bottomRightInScreen)));
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u000026\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002`\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0007J<\u0010\b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00022\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002H\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$TopBottomBoundsComparator;", "Ljava/util/Comparator;", "Lkotlin/Pair;", "Landroidx/compose/ui/geometry/Rect;", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class TopBottomBoundsComparator implements Comparator<Pair<? extends androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>>> {
        public static final TopBottomBoundsComparator INSTANCE = new TopBottomBoundsComparator();

        private TopBottomBoundsComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Pair<? extends androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> pair, Pair<? extends androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> pair2) {
            return compare2((Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>>) pair, (Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>>) pair2);
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> a, Pair<androidx.compose.ui.geometry.Rect, ? extends List<SemanticsNode>> b) {
            int r = Float.compare(a.getFirst().getTop(), b.getFirst().getTop());
            return r != 0 ? r : Float.compare(a.getFirst().getBottom(), b.getFirst().getBottom());
        }
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$LtrBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class LtrBoundsComparator implements Comparator<SemanticsNode> {
        public static final LtrBoundsComparator INSTANCE = new LtrBoundsComparator();

        private LtrBoundsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(SemanticsNode a, SemanticsNode b) {
            androidx.compose.ui.geometry.Rect ab = a.getBoundsInWindow();
            androidx.compose.ui.geometry.Rect bb = b.getBoundsInWindow();
            int r = Float.compare(ab.getLeft(), bb.getLeft());
            if (r != 0) {
                return r;
            }
            int r2 = Float.compare(ab.getTop(), bb.getTop());
            if (r2 != 0) {
                return r2;
            }
            int r3 = Float.compare(ab.getBottom(), bb.getBottom());
            return r3 != 0 ? r3 : Float.compare(ab.getRight(), bb.getRight());
        }
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$RtlBoundsComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/semantics/SemanticsNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class RtlBoundsComparator implements Comparator<SemanticsNode> {
        public static final RtlBoundsComparator INSTANCE = new RtlBoundsComparator();

        private RtlBoundsComparator() {
        }

        @Override // java.util.Comparator
        public int compare(SemanticsNode a, SemanticsNode b) {
            androidx.compose.ui.geometry.Rect ab = a.getBoundsInWindow();
            androidx.compose.ui.geometry.Rect bb = b.getBoundsInWindow();
            int r = Float.compare(bb.getRight(), ab.getRight());
            if (r != 0) {
                return r;
            }
            int r2 = Float.compare(ab.getTop(), bb.getTop());
            if (r2 != 0) {
                return r2;
            }
            int r3 = Float.compare(ab.getBottom(), bb.getBottom());
            return r3 != 0 ? r3 : Float.compare(bb.getLeft(), ab.getLeft());
        }
    }

    private final Comparator<SemanticsNode> semanticComparator(boolean layoutIsRtl) {
        return new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$2(new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1(layoutIsRtl ? RtlBoundsComparator.INSTANCE : LtrBoundsComparator.INSTANCE, LayoutNode.INSTANCE.getZComparator$ui_release()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ List sortByGeometryGroupings$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z, ArrayList arrayList, MutableIntObjectMap mutableIntObjectMap, int i, Object obj) {
        if ((i & 4) != 0) {
            mutableIntObjectMap = IntObjectMapKt.mutableIntObjectMapOf();
        }
        return androidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings(z, arrayList, mutableIntObjectMap);
    }

    private final List<SemanticsNode> sortByGeometryGroupings(boolean layoutIsRtl, ArrayList<SemanticsNode> parentListToSort, MutableIntObjectMap<List<SemanticsNode>> containerChildrenMapping) {
        ArrayList rowGroupings = new ArrayList();
        int entryIndex = 0;
        int lastIndex = CollectionsKt.getLastIndex(parentListToSort);
        if (0 <= lastIndex) {
            while (true) {
                SemanticsNode currEntry = parentListToSort.get(entryIndex);
                if (entryIndex == 0 || !sortByGeometryGroupings$placedEntryRowOverlaps(rowGroupings, currEntry)) {
                    androidx.compose.ui.geometry.Rect newRect = currEntry.getBoundsInWindow();
                    rowGroupings.add(new Pair(newRect, CollectionsKt.mutableListOf(currEntry)));
                }
                if (entryIndex == lastIndex) {
                    break;
                }
                entryIndex++;
            }
        }
        CollectionsKt.sortWith(rowGroupings, TopBottomBoundsComparator.INSTANCE);
        ArrayList returnList = new ArrayList();
        ArrayList $this$fastForEach$iv = rowGroupings;
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            Pair row = (Pair) item$iv;
            CollectionsKt.sortWith((List) row.getSecond(), new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$2(new AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1(layoutIsRtl ? RtlBoundsComparator.INSTANCE : LtrBoundsComparator.INSTANCE, LayoutNode.INSTANCE.getZComparator$ui_release())));
            returnList.addAll((Collection) row.getSecond());
        }
        final AnonymousClass2 anonymousClass2 = new Function2<SemanticsNode, SemanticsNode, Integer>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings.2
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(SemanticsNode a, SemanticsNode b) {
                return Integer.valueOf(Float.compare(((Number) a.getUnmergedConfig().getOrElse(SemanticsProperties.INSTANCE.getTraversalIndex(), new Function0<Float>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings.2.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue(), ((Number) b.getUnmergedConfig().getOrElse(SemanticsProperties.INSTANCE.getTraversalIndex(), new Function0<Float>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sortByGeometryGroupings.2.2
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue()));
            }
        };
        CollectionsKt.sortWith(returnList, new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Number) anonymousClass2.invoke(obj, obj2)).intValue();
            }
        });
        int i = 0;
        while (i <= CollectionsKt.getLastIndex(returnList)) {
            int currNodeId = ((SemanticsNode) returnList.get(i)).getId();
            List containersChildrenList = containerChildrenMapping.get(currNodeId);
            if (containersChildrenList != null) {
                boolean containerIsScreenReaderFocusable = isScreenReaderFocusable((SemanticsNode) returnList.get(i));
                if (containerIsScreenReaderFocusable) {
                    i++;
                } else {
                    returnList.remove(i);
                }
                returnList.addAll(i, containersChildrenList);
                i += containersChildrenList.size();
            } else {
                i++;
            }
        }
        return returnList;
    }

    private static final boolean sortByGeometryGroupings$placedEntryRowOverlaps(ArrayList<Pair<androidx.compose.ui.geometry.Rect, List<SemanticsNode>>> arrayList, SemanticsNode node) {
        float entryTopCoord = node.getBoundsInWindow().getTop();
        float entryBottomCoord = node.getBoundsInWindow().getBottom();
        boolean entryIsEmpty = entryTopCoord >= entryBottomCoord;
        int currIndex = 0;
        int lastIndex = CollectionsKt.getLastIndex(arrayList);
        if (0 <= lastIndex) {
            while (true) {
                androidx.compose.ui.geometry.Rect currRect = arrayList.get(currIndex).getFirst();
                boolean groupIsEmpty = currRect.getTop() >= currRect.getBottom();
                boolean groupOverlapsEntry = (entryIsEmpty || groupIsEmpty || Math.max(entryTopCoord, currRect.getTop()) >= Math.min(entryBottomCoord, currRect.getBottom())) ? false : true;
                if (!groupOverlapsEntry) {
                    if (currIndex == lastIndex) {
                        break;
                    }
                    currIndex++;
                } else {
                    androidx.compose.ui.geometry.Rect newRect = currRect.intersect(0.0f, entryTopCoord, Float.POSITIVE_INFINITY, entryBottomCoord);
                    arrayList.set(currIndex, new Pair<>(newRect, arrayList.get(currIndex).getSecond()));
                    arrayList.get(currIndex).getSecond().add(node);
                    return true;
                }
            }
        }
        return false;
    }

    private final void geometryDepthFirstSearch(SemanticsNode currNode, ArrayList<SemanticsNode> geometryList, MutableIntObjectMap<List<SemanticsNode>> containerMapToChildren) {
        boolean currRTL = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(currNode);
        boolean isTraversalGroup = ((Boolean) currNode.getUnmergedConfig().getOrElse(SemanticsProperties.INSTANCE.getIsTraversalGroup(), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$geometryDepthFirstSearch$isTraversalGroup$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return false;
            }
        })).booleanValue();
        if ((isTraversalGroup || isScreenReaderFocusable(currNode)) && getCurrentSemanticsNodes().containsKey(currNode.getId())) {
            geometryList.add(currNode);
        }
        if (isTraversalGroup) {
            containerMapToChildren.set(currNode.getId(), subtreeSortedByGeometryGrouping(currRTL, CollectionsKt.toMutableList((Collection) currNode.getChildren())));
            return;
        }
        List $this$fastForEach$iv = currNode.getChildren();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            geometryDepthFirstSearch(child, geometryList, containerMapToChildren);
        }
    }

    private final List<SemanticsNode> subtreeSortedByGeometryGrouping(boolean layoutIsRtl, List<SemanticsNode> listToSort) {
        MutableIntObjectMap containerMapToChildren = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList geometryList = new ArrayList();
        int size = listToSort.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = listToSort.get(index$iv);
            SemanticsNode node = (SemanticsNode) item$iv;
            geometryDepthFirstSearch(node, geometryList, containerMapToChildren);
        }
        List $this$fastForEach$iv = sortByGeometryGroupings(layoutIsRtl, geometryList, containerMapToChildren);
        return $this$fastForEach$iv;
    }

    private final void setTraversalValues() {
        this.idToBeforeMap.clear();
        this.idToAfterMap.clear();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(-1);
        SemanticsNode hostSemanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
        Intrinsics.checkNotNull(hostSemanticsNode);
        boolean hostLayoutIsRtl = AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(hostSemanticsNode);
        List semanticsOrderList = subtreeSortedByGeometryGrouping(hostLayoutIsRtl, CollectionsKt.mutableListOf(hostSemanticsNode));
        int i = 1;
        int lastIndex = CollectionsKt.getLastIndex(semanticsOrderList);
        if (1 > lastIndex) {
            return;
        }
        while (true) {
            int prevId = semanticsOrderList.get(i - 1).getId();
            int currId = semanticsOrderList.get(i).getId();
            this.idToBeforeMap.set(prevId, currId);
            this.idToAfterMap.set(currId, prevId);
            if (i == lastIndex) {
                return;
            } else {
                i++;
            }
        }
    }

    private final boolean isScreenReaderFocusable(SemanticsNode node) {
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getContentDescription());
        String nodeContentDescriptionOrNull = list != null ? (String) CollectionsKt.firstOrNull(list) : null;
        boolean isSpeakingNode = (nodeContentDescriptionOrNull == null && getInfoText(node) == null && getInfoStateDescriptionOrNull(node) == null && !getInfoIsCheckable(node)) ? false : true;
        return node.getUnmergedConfig().getIsMergingSemanticsOfDescendants() || (node.isUnmergedLeafNode$ui_release() && isSpeakingNode);
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x03b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void populateAccessibilityNodeInfoProperties(int r31, androidx.core.view.accessibility.AccessibilityNodeInfoCompat r32, androidx.compose.ui.semantics.SemanticsNode r33) {
        /*
            Method dump skipped, instructions count: 2719
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties(int, androidx.core.view.accessibility.AccessibilityNodeInfoCompat, androidx.compose.ui.semantics.SemanticsNode):void");
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange $this$populateAccessibilityNodeInfoProperties_u24canScrollForward) {
        return ($this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getValue().invoke().floatValue() < $this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getMaxValue().invoke().floatValue() && !$this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getReverseScrolling()) || ($this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getValue().invoke().floatValue() > 0.0f && $this$populateAccessibilityNodeInfoProperties_u24canScrollForward.getReverseScrolling());
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward) {
        return ($this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getValue().invoke().floatValue() > 0.0f && !$this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getReverseScrolling()) || ($this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getValue().invoke().floatValue() < $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getMaxValue().invoke().floatValue() && $this$populateAccessibilityNodeInfoProperties_u24canScrollBackward.getReverseScrolling());
    }

    private final void setContentInvalid(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getError())) {
            info.setContentInvalid(true);
            info.setError((CharSequence) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getError()));
        }
    }

    private final String getInfoStateDescriptionOrNull(SemanticsNode node) throws Resources.NotFoundException {
        int percent;
        Object string;
        Object stateDescription = SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getStateDescription());
        ToggleableState toggleState = (ToggleableState) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
        if (toggleState != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[toggleState.ordinal()]) {
                case 1:
                    if ((role == null ? false : Role.m5952equalsimpl0(role.getValue(), Role.INSTANCE.m5961getSwitcho7Vup1c())) && stateDescription == null) {
                        stateDescription = this.view.getContext().getResources().getString(R.string.state_on);
                        break;
                    }
                    break;
                case 2:
                    if ((role == null ? false : Role.m5952equalsimpl0(role.getValue(), Role.INSTANCE.m5961getSwitcho7Vup1c())) && stateDescription == null) {
                        stateDescription = this.view.getContext().getResources().getString(R.string.state_off);
                        break;
                    }
                    break;
                case 3:
                    if (stateDescription == null) {
                        stateDescription = this.view.getContext().getResources().getString(R.string.indeterminate);
                        break;
                    }
                    break;
            }
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected());
        if (bool != null) {
            boolean it = bool.booleanValue();
            if (!(role == null ? false : Role.m5952equalsimpl0(role.getValue(), Role.INSTANCE.m5962getTabo7Vup1c())) && stateDescription == null) {
                AndroidComposeView androidComposeView = this.view;
                if (it) {
                    string = androidComposeView.getContext().getResources().getString(R.string.selected);
                } else {
                    string = androidComposeView.getContext().getResources().getString(R.string.not_selected);
                }
                stateDescription = string;
            }
        }
        ProgressBarRangeInfo rangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
        if (rangeInfo != null) {
            if (rangeInfo != ProgressBarRangeInfo.INSTANCE.getIndeterminate()) {
                if (stateDescription == null) {
                    ClosedFloatingPointRange valueRange = rangeInfo.getRange();
                    float $this$fastCoerceIn$iv = ((valueRange.getEndInclusive().floatValue() - valueRange.getStart().floatValue()) > 0.0f ? 1 : ((valueRange.getEndInclusive().floatValue() - valueRange.getStart().floatValue()) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (rangeInfo.getCurrent() - valueRange.getStart().floatValue()) / (valueRange.getEndInclusive().floatValue() - valueRange.getStart().floatValue());
                    float $this$fastCoerceAtLeast$iv$iv = $this$fastCoerceIn$iv;
                    if ($this$fastCoerceAtLeast$iv$iv < 0.0f) {
                        $this$fastCoerceAtLeast$iv$iv = 0.0f;
                    }
                    if ($this$fastCoerceAtLeast$iv$iv > 1.0f) {
                        $this$fastCoerceAtLeast$iv$iv = 1.0f;
                    }
                    if ($this$fastCoerceAtLeast$iv$iv == 0.0f) {
                        percent = 0;
                    } else {
                        if ($this$fastCoerceAtLeast$iv$iv == 1.0f) {
                            percent = 100;
                        } else {
                            float $this$fastRoundToInt$iv = 100.0f * $this$fastCoerceAtLeast$iv$iv;
                            percent = RangesKt.coerceIn(Math.round($this$fastRoundToInt$iv), 1, 99);
                        }
                    }
                    stateDescription = this.view.getContext().getResources().getString(R.string.template_percent, Integer.valueOf(percent));
                }
            } else if (stateDescription == null) {
                stateDescription = this.view.getContext().getResources().getString(R.string.in_progress);
            }
        }
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            stateDescription = createStateDescriptionForTextField(node);
        }
        return (String) stateDescription;
    }

    private final String createStateDescriptionForTextField(SemanticsNode node) {
        SemanticsConfiguration mergedConfig = node.copyWithMergingEnabled$ui_release().getConfig();
        Collection collection = (Collection) SemanticsConfigurationKt.getOrNull(mergedConfig, SemanticsProperties.INSTANCE.getContentDescription());
        boolean mergedNodeIsUnspeakable = false;
        if (collection == null || collection.isEmpty()) {
            Collection collection2 = (Collection) SemanticsConfigurationKt.getOrNull(mergedConfig, SemanticsProperties.INSTANCE.getText());
            if (collection2 == null || collection2.isEmpty()) {
                CharSequence charSequence = (CharSequence) SemanticsConfigurationKt.getOrNull(mergedConfig, SemanticsProperties.INSTANCE.getEditableText());
                if (charSequence == null || charSequence.length() == 0) {
                    mergedNodeIsUnspeakable = true;
                }
            }
        }
        if (mergedNodeIsUnspeakable) {
            return this.view.getContext().getResources().getString(R.string.state_empty);
        }
        return null;
    }

    private final void setStateDescription(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        info.setStateDescription(getInfoStateDescriptionOrNull(node));
    }

    private final boolean getInfoIsCheckable(SemanticsNode node) {
        boolean isCheckable = false;
        ToggleableState toggleState = (ToggleableState) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getToggleableState());
        Role role = (Role) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getRole());
        if (toggleState != null) {
            isCheckable = true;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getSelected());
        if (bool == null) {
            return isCheckable;
        }
        bool.booleanValue();
        if (!(role == null ? false : Role.m5952equalsimpl0(role.getValue(), Role.INSTANCE.m5962getTabo7Vup1c()))) {
            return true;
        }
        return isCheckable;
    }

    private final void setIsCheckable(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        info.setCheckable(getInfoIsCheckable(node));
    }

    private final AnnotatedString getInfoText(SemanticsNode node) {
        AnnotatedString editableTextToAssign = getTextForTextField(node.getUnmergedConfig());
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
        AnnotatedString textToAssign = list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null;
        return editableTextToAssign == null ? textToAssign : editableTextToAssign;
    }

    private final SpannableString toSpannableString(AnnotatedString $this$toSpannableString) {
        FontFamily.Resolver fontFamilyResolver = this.view.getFontFamilyResolver();
        return (SpannableString) trimToSize(AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString($this$toSpannableString, this.view.getDensity(), fontFamilyResolver, this.urlSpanCache), ParcelSafeTextLength);
    }

    private final void setText(SemanticsNode node, AccessibilityNodeInfoCompat info) {
        AnnotatedString infoText = getInfoText(node);
        info.setText(infoText != null ? toSpannableString(infoText) : null);
    }

    private final boolean isAccessibilityFocused(int virtualViewId) {
        return this.focusedVirtualViewId == virtualViewId;
    }

    private final boolean requestAccessibilityFocus(int virtualViewId) {
        if (!isTouchExplorationEnabled() || isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        if (this.focusedVirtualViewId != Integer.MIN_VALUE) {
            sendEventForVirtualView$default(this, this.focusedVirtualViewId, 65536, null, null, 12, null);
        }
        this.focusedVirtualViewId = virtualViewId;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 32768, null, null, 12, null);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i, int i2, Integer num, List list, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i, i2, num, list);
    }

    private final boolean sendEventForVirtualView(int virtualViewId, int eventType, Integer contentChangeType, List<String> contentDescription) {
        if (virtualViewId != Integer.MIN_VALUE && isEnabled$ui_release()) {
            AccessibilityEvent event = createEvent(virtualViewId, eventType);
            if (contentChangeType != null) {
                event.setContentChangeTypes(contentChangeType.intValue());
            }
            if (contentDescription != null) {
                event.setContentDescription(ListUtilsKt.fastJoinToString$default(contentDescription, ",", null, null, 0, null, null, 62, null));
            }
            Trace.beginSection("sendEvent");
            try {
                return sendEvent(event);
            } finally {
                Trace.endSection();
            }
        }
        return false;
    }

    private final boolean sendEvent(AccessibilityEvent event) {
        if (!isEnabled$ui_release()) {
            return false;
        }
        if (event.getEventType() == 2048 || event.getEventType() == 32768) {
            this.sendingFocusAffectingEvent = true;
        }
        try {
            return this.onSendAccessibilityEvent.invoke(event).booleanValue();
        } finally {
            this.sendingFocusAffectingEvent = false;
        }
    }

    private final AccessibilityEvent createEvent(int virtualViewId, int eventType) {
        SemanticsNodeWithAdjustedBounds it;
        Trace.beginSection("obtainAccessibilityEvent");
        try {
            AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
            Trace.endSection();
            event.setEnabled(true);
            event.setClassName(ClassName);
            Trace.beginSection("event.packageName");
            try {
                event.setPackageName(this.view.getContext().getPackageName());
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                Trace.beginSection("event.setSource");
                try {
                    event.setSource(this.view, virtualViewId);
                    Unit unit2 = Unit.INSTANCE;
                    Trace.endSection();
                    if (isEnabled$ui_release() && (it = getCurrentSemanticsNodes().get(virtualViewId)) != null) {
                        event.setPassword(it.getSemanticsNode().getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPassword()));
                    }
                    return event;
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int virtualViewId, Integer fromIndex, Integer toIndex, Integer itemCount, CharSequence text) {
        AccessibilityEvent $this$createTextSelectionChangedEvent_u24lambda_u2453 = createEvent(virtualViewId, 8192);
        if (fromIndex != null) {
            int it = fromIndex.intValue();
            $this$createTextSelectionChangedEvent_u24lambda_u2453.setFromIndex(it);
        }
        if (toIndex != null) {
            int it2 = toIndex.intValue();
            $this$createTextSelectionChangedEvent_u24lambda_u2453.setToIndex(it2);
        }
        if (itemCount != null) {
            int it3 = itemCount.intValue();
            $this$createTextSelectionChangedEvent_u24lambda_u2453.setItemCount(it3);
        }
        if (text != null) {
            $this$createTextSelectionChangedEvent_u24lambda_u2453.getText().add(text);
        }
        return $this$createTextSelectionChangedEvent_u24lambda_u2453;
    }

    private final boolean clearAccessibilityFocus(int virtualViewId) {
        if (!isAccessibilityFocused(virtualViewId)) {
            return false;
        }
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.currentlyFocusedANI = null;
        this.view.invalidate();
        sendEventForVirtualView$default(this, virtualViewId, 65536, null, null, 12, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean performActionHelper(int virtualViewId, int action, Bundle arguments) {
        SemanticsNode semanticsNode;
        Function0 function0;
        boolean z;
        long j;
        float f;
        SemanticsConfiguration unmergedConfig;
        SemanticsConfiguration unmergedConfig2;
        AccessibilityAction accessibilityAction;
        CharSequence charSequence;
        List list;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
        if (semanticsNodeWithAdjustedBounds != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null) {
            switch (action) {
                case 64:
                    break;
                case 128:
                    break;
                case 256:
                case 512:
                    if (arguments != null) {
                        break;
                    }
                    break;
                case 16384:
                    AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCopyText());
                    if (accessibilityAction2 != null && (r1 = (Function0) accessibilityAction2.getAction()) != null) {
                        break;
                    }
                    break;
                case 131072:
                    boolean accessibilitySelection = setAccessibilitySelection(semanticsNode, arguments != null ? arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT, -1) : -1, arguments != null ? arguments.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT, -1) : -1, false);
                    if (accessibilitySelection) {
                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId()), 0, null, null, 12, null);
                        break;
                    }
                    break;
                default:
                    if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                        Boolean bool = null;
                        bool = null;
                        switch (action) {
                            case 1:
                                AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getRequestFocus());
                                if (accessibilityAction3 != null && (r2 = (Function0) accessibilityAction3.getAction()) != null) {
                                    break;
                                }
                                break;
                            case 2:
                                if (Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getFocused()), (Object) true)) {
                                    this.view.getFocusOwner().mo3873clearFocusI7lrPNg(false, true, true, FocusDirection.INSTANCE.m3865getExitdhqQ8s());
                                    break;
                                }
                                break;
                            case 16:
                                AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnClick());
                                if (accessibilityAction4 != null && (function0 = (Function0) accessibilityAction4.getAction()) != null) {
                                    bool = (Boolean) function0.invoke();
                                }
                                Boolean bool2 = bool;
                                sendEventForVirtualView$default(this, virtualViewId, 1, null, null, 12, null);
                                if (bool2 != null) {
                                    break;
                                }
                                break;
                            case 32:
                                AccessibilityAction accessibilityAction5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnLongClick());
                                if (accessibilityAction5 != null && (r0 = (Function0) accessibilityAction5.getAction()) != null) {
                                    break;
                                }
                                break;
                            case 4096:
                            case 8192:
                            case android.R.id.accessibilityActionScrollUp:
                            case android.R.id.accessibilityActionScrollLeft:
                            case android.R.id.accessibilityActionScrollDown:
                            case android.R.id.accessibilityActionScrollRight:
                                boolean z2 = action == 4096;
                                boolean z3 = action == 8192;
                                boolean z4 = action == 16908345;
                                boolean z5 = action == 16908347;
                                boolean z6 = action == 16908344;
                                boolean z7 = action == 16908346;
                                boolean z8 = z4 || z5 || z2 || z3;
                                boolean z9 = z6 || z7 || z2 || z3;
                                if (z2 || z3) {
                                    ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getProgressBarRangeInfo());
                                    AccessibilityAction accessibilityAction6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress());
                                    if (progressBarRangeInfo != null && accessibilityAction6 != null) {
                                        float fCoerceAtLeast = RangesKt.coerceAtLeast(progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getRange().getStart().floatValue());
                                        float fCoerceAtMost = RangesKt.coerceAtMost(progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue());
                                        float steps = progressBarRangeInfo.getSteps() > 0 ? (fCoerceAtLeast - fCoerceAtMost) / (progressBarRangeInfo.getSteps() + 1) : (fCoerceAtLeast - fCoerceAtMost) / 20.0f;
                                        if (z3) {
                                            steps = -steps;
                                        }
                                        Function1 function1 = (Function1) accessibilityAction6.getAction();
                                        if (function1 != null) {
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        z = z3;
                                    }
                                } else {
                                    z = z3;
                                }
                                long jM3978getSizeNHjbRc = LayoutCoordinatesKt.boundsInParent(semanticsNode.getLayoutInfo().getCoordinates()).m3978getSizeNHjbRc();
                                Float scrollViewportLength = SemanticsUtils_androidKt.getScrollViewportLength(semanticsNode.getUnmergedConfig());
                                AccessibilityAction accessibilityAction7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getScrollBy());
                                if (accessibilityAction7 != null) {
                                    ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
                                    if (scrollAxisRange == null || !z8) {
                                        j = jM3978getSizeNHjbRc;
                                        f = 0.0f;
                                    } else {
                                        float fFloatValue = scrollViewportLength != null ? scrollViewportLength.floatValue() : Size.m4014getWidthimpl(jM3978getSizeNHjbRc);
                                        if (z4 || z) {
                                            fFloatValue = -fFloatValue;
                                        }
                                        if (scrollAxisRange.getReverseScrolling()) {
                                            fFloatValue = -fFloatValue;
                                        }
                                        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode) && (z4 || z5)) {
                                            fFloatValue = -fFloatValue;
                                        }
                                        if (!performActionHelper$canScroll(scrollAxisRange, fFloatValue)) {
                                            j = jM3978getSizeNHjbRc;
                                            f = 0.0f;
                                        } else if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getPageLeft()) || semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getPageRight())) {
                                            AccessibilityAction accessibilityAction8 = fFloatValue > 0.0f ? (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageRight()) : (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageLeft());
                                            if (accessibilityAction8 != null && (r14 = (Function0) accessibilityAction8.getAction()) != null) {
                                                break;
                                            } else {
                                                break;
                                            }
                                        } else {
                                            Function2 function2 = (Function2) accessibilityAction7.getAction();
                                            if (function2 != null) {
                                                break;
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
                                    if (scrollAxisRange2 == null || !z9) {
                                        break;
                                    } else {
                                        float fFloatValue2 = scrollViewportLength != null ? scrollViewportLength.floatValue() : Size.m4011getHeightimpl(j);
                                        if (z6 || z) {
                                            fFloatValue2 = -fFloatValue2;
                                        }
                                        if (scrollAxisRange2.getReverseScrolling()) {
                                            fFloatValue2 = -fFloatValue2;
                                        }
                                        if (performActionHelper$canScroll(scrollAxisRange2, fFloatValue2)) {
                                            if (semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getPageUp()) || semanticsNode.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getPageDown())) {
                                                AccessibilityAction accessibilityAction9 = fFloatValue2 > f ? (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageDown()) : (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageUp());
                                                if (accessibilityAction9 != null && (r15 = (Function0) accessibilityAction9.getAction()) != null) {
                                                    break;
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                Function2 function22 = (Function2) accessibilityAction7.getAction();
                                                if (function22 != null) {
                                                    break;
                                                } else {
                                                    break;
                                                }
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 32768:
                                AccessibilityAction accessibilityAction10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPasteText());
                                if (accessibilityAction10 != null && (r0 = (Function0) accessibilityAction10.getAction()) != null) {
                                    break;
                                }
                                break;
                            case 65536:
                                AccessibilityAction accessibilityAction11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCutText());
                                if (accessibilityAction11 != null && (r0 = (Function0) accessibilityAction11.getAction()) != null) {
                                    break;
                                }
                                break;
                            case 262144:
                                AccessibilityAction accessibilityAction12 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getExpand());
                                if (accessibilityAction12 != null && (r0 = (Function0) accessibilityAction12.getAction()) != null) {
                                    break;
                                }
                                break;
                            case 524288:
                                AccessibilityAction accessibilityAction13 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCollapse());
                                if (accessibilityAction13 != null && (r0 = (Function0) accessibilityAction13.getAction()) != null) {
                                    break;
                                }
                                break;
                            case 1048576:
                                AccessibilityAction accessibilityAction14 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getDismiss());
                                if (accessibilityAction14 != null && (r0 = (Function0) accessibilityAction14.getAction()) != null) {
                                    break;
                                }
                                break;
                            case 2097152:
                                String string = arguments != null ? arguments.getString(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE) : null;
                                AccessibilityAction accessibilityAction15 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetText());
                                if (accessibilityAction15 != null && (r0 = (Function1) accessibilityAction15.getAction()) != null) {
                                    break;
                                }
                                break;
                            case android.R.id.accessibilityActionShowOnScreen:
                                SemanticsNode parent = semanticsNode.getParent();
                                AccessibilityAction accessibilityAction16 = (parent == null || (unmergedConfig2 = parent.getUnmergedConfig()) == null) ? null : (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig2, SemanticsActions.INSTANCE.getScrollBy());
                                while (parent != null && accessibilityAction16 == null) {
                                    parent = parent.getParent();
                                    accessibilityAction16 = (parent == null || (unmergedConfig = parent.getUnmergedConfig()) == null) ? null : (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsActions.INSTANCE.getScrollBy());
                                }
                                if (parent != null) {
                                    androidx.compose.ui.geometry.Rect rectBoundsInParent = LayoutCoordinatesKt.boundsInParent(parent.getLayoutInfo().getCoordinates());
                                    LayoutCoordinates parentLayoutCoordinates = parent.getLayoutInfo().getCoordinates().getParentLayoutCoordinates();
                                    androidx.compose.ui.geometry.Rect rectM3982translatek4lQ0M = rectBoundsInParent.m3982translatek4lQ0M(parentLayoutCoordinates != null ? LayoutCoordinatesKt.positionInRoot(parentLayoutCoordinates) : Offset.INSTANCE.m3961getZeroF1C5BW0());
                                    androidx.compose.ui.geometry.Rect rectM3985Recttz77jQw = RectKt.m3985Recttz77jQw(semanticsNode.m5964getPositionInRootF1C5BW0(), IntSizeKt.m6879toSizeozmzZPI(semanticsNode.m5967getSizeYbymL2g()));
                                    ScrollAxisRange scrollAxisRange3 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(parent.getUnmergedConfig(), SemanticsProperties.INSTANCE.getHorizontalScrollAxisRange());
                                    ScrollAxisRange scrollAxisRange4 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(parent.getUnmergedConfig(), SemanticsProperties.INSTANCE.getVerticalScrollAxisRange());
                                    float fPerformActionHelper$scrollDelta = performActionHelper$scrollDelta(rectM3985Recttz77jQw.getLeft() - rectM3982translatek4lQ0M.getLeft(), rectM3985Recttz77jQw.getRight() - rectM3982translatek4lQ0M.getRight());
                                    if (scrollAxisRange3 != null && scrollAxisRange3.getReverseScrolling()) {
                                        fPerformActionHelper$scrollDelta = -fPerformActionHelper$scrollDelta;
                                    }
                                    if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode)) {
                                        fPerformActionHelper$scrollDelta = -fPerformActionHelper$scrollDelta;
                                    }
                                    float fPerformActionHelper$scrollDelta2 = performActionHelper$scrollDelta(rectM3985Recttz77jQw.getTop() - rectM3982translatek4lQ0M.getTop(), rectM3985Recttz77jQw.getBottom() - rectM3982translatek4lQ0M.getBottom());
                                    if (scrollAxisRange4 != null && scrollAxisRange4.getReverseScrolling()) {
                                        fPerformActionHelper$scrollDelta2 = -fPerformActionHelper$scrollDelta2;
                                    }
                                    if (accessibilityAction16 != null && (r0 = (Function2) accessibilityAction16.getAction()) != null) {
                                        break;
                                    } else {
                                        break;
                                    }
                                }
                                break;
                            case android.R.id.accessibilityActionSetProgress:
                                if (arguments != null && arguments.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress())) != null && (r2 = (Function1) accessibilityAction.getAction()) != null) {
                                    break;
                                }
                                break;
                            case android.R.id.accessibilityActionPageUp:
                                AccessibilityAction accessibilityAction17 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageUp());
                                if (accessibilityAction17 != null && (r2 = (Function0) accessibilityAction17.getAction()) != null) {
                                    break;
                                }
                                break;
                            case android.R.id.accessibilityActionPageDown:
                                AccessibilityAction accessibilityAction18 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageDown());
                                if (accessibilityAction18 != null && (r2 = (Function0) accessibilityAction18.getAction()) != null) {
                                    break;
                                }
                                break;
                            case android.R.id.accessibilityActionPageLeft:
                                AccessibilityAction accessibilityAction19 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageLeft());
                                if (accessibilityAction19 != null && (r2 = (Function0) accessibilityAction19.getAction()) != null) {
                                    break;
                                }
                                break;
                            case android.R.id.accessibilityActionPageRight:
                                AccessibilityAction accessibilityAction20 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageRight());
                                if (accessibilityAction20 != null && (r2 = (Function0) accessibilityAction20.getAction()) != null) {
                                    break;
                                }
                                break;
                            case android.R.id.accessibilityActionImeEnter:
                                AccessibilityAction accessibilityAction21 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getOnImeAction());
                                if (accessibilityAction21 != null && (r1 = (Function0) accessibilityAction21.getAction()) != null) {
                                    break;
                                }
                                break;
                            default:
                                SparseArrayCompat<CharSequence> sparseArrayCompat = this.actionIdToLabel.get(virtualViewId);
                                if (sparseArrayCompat != null && (charSequence = sparseArrayCompat.get(action)) != null && (list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getCustomActions())) != null) {
                                    int size = list.size();
                                    for (int i = 0; i < size; i++) {
                                        CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) list.get(i);
                                        if (Intrinsics.areEqual(customAccessibilityAction.getLabel(), charSequence)) {
                                            break;
                                        }
                                    }
                                    break;
                                }
                                break;
                        }
                    }
                    break;
            }
            return false;
        }
        return false;
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange $this$performActionHelper_u24canScroll, float amount) {
        return (amount < 0.0f && $this$performActionHelper_u24canScroll.getValue().invoke().floatValue() > 0.0f) || (amount > 0.0f && $this$performActionHelper_u24canScroll.getValue().invoke().floatValue() < $this$performActionHelper_u24canScroll.getMaxValue().invoke().floatValue());
    }

    private static final float performActionHelper$scrollDelta(float a, float b) {
        if (Math.signum(a) == Math.signum(b)) {
            return Math.abs(a) < Math.abs(b) ? a : b;
        }
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int virtualViewId, AccessibilityNodeInfoCompat info, String extraDataKey, Bundle arguments) {
        SemanticsNode node;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(virtualViewId);
        if (semanticsNodeWithAdjustedBounds == null || (node = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null) {
            return;
        }
        String text = getIterableTextForAccessibility(node);
        if (Intrinsics.areEqual(extraDataKey, this.ExtraDataTestTraversalBeforeVal)) {
            int it = this.idToBeforeMap.getOrDefault(virtualViewId, -1);
            if (it != -1) {
                info.getExtras().putInt(extraDataKey, it);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, this.ExtraDataTestTraversalAfterVal)) {
            int it2 = this.idToAfterMap.getOrDefault(virtualViewId, -1);
            if (it2 != -1) {
                info.getExtras().putInt(extraDataKey, it2);
                return;
            }
            return;
        }
        if (node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) && arguments != null && Intrinsics.areEqual(extraDataKey, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            int positionInfoStartIndex = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
            int positionInfoLength = arguments.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
            if (positionInfoLength > 0 && positionInfoStartIndex >= 0) {
                if (positionInfoStartIndex < (text != null ? text.length() : Integer.MAX_VALUE)) {
                    TextLayoutResult textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(node.getUnmergedConfig());
                    if (textLayoutResult == null) {
                        return;
                    }
                    List boundingRects = new ArrayList();
                    for (int i = 0; i < positionInfoLength; i++) {
                        if (positionInfoStartIndex + i >= textLayoutResult.getLayoutInput().getText().length()) {
                            boundingRects.add(null);
                        } else {
                            androidx.compose.ui.geometry.Rect bounds = textLayoutResult.getBoundingBox(positionInfoStartIndex + i);
                            RectF boundsOnScreen = toScreenCoords(node, bounds);
                            boundingRects.add(boundsOnScreen);
                        }
                    }
                    List $this$toTypedArray$iv = boundingRects;
                    info.getExtras().putParcelableArray(extraDataKey, (Parcelable[]) $this$toTypedArray$iv.toArray(new RectF[0]));
                    return;
                }
            }
            Log.e(LogTag, "Invalid arguments for accessibility character locations");
            return;
        }
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTestTag()) && arguments != null && Intrinsics.areEqual(extraDataKey, ExtraDataTestTagKey)) {
            String testTag = (String) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getTestTag());
            if (testTag != null) {
                info.getExtras().putCharSequence(extraDataKey, testTag);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(extraDataKey, ExtraDataIdKey)) {
            info.getExtras().putInt(extraDataKey, node.getId());
        }
    }

    private final RectF toScreenCoords(SemanticsNode textNode, androidx.compose.ui.geometry.Rect bounds) {
        androidx.compose.ui.geometry.Rect visibleBounds;
        if (textNode == null) {
            return null;
        }
        androidx.compose.ui.geometry.Rect boundsInRoot = bounds.m3982translatek4lQ0M(textNode.m5964getPositionInRootF1C5BW0());
        androidx.compose.ui.geometry.Rect textNodeBoundsInRoot = textNode.getBoundsInRoot();
        if (boundsInRoot.overlaps(textNodeBoundsInRoot)) {
            visibleBounds = boundsInRoot.intersect(textNodeBoundsInRoot);
        } else {
            visibleBounds = null;
        }
        if (visibleBounds == null) {
            return null;
        }
        long topLeftInScreen = this.view.mo5487localToScreenMKHz9U(OffsetKt.Offset(visibleBounds.getLeft(), visibleBounds.getTop()));
        long bottomRightInScreen = this.view.mo5487localToScreenMKHz9U(OffsetKt.Offset(visibleBounds.getRight(), visibleBounds.getBottom()));
        return new RectF(Offset.m3945getXimpl(topLeftInScreen), Offset.m3946getYimpl(topLeftInScreen), Offset.m3945getXimpl(bottomRightInScreen), Offset.m3946getYimpl(bottomRightInScreen));
    }

    public final boolean dispatchHoverEvent$ui_release(MotionEvent event) {
        if (!isTouchExplorationEnabled()) {
            return false;
        }
        switch (event.getAction()) {
            case 7:
            case 9:
                int virtualViewId = hitTestSemanticsAt$ui_release(event.getX(), event.getY());
                boolean handled = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
                updateHoveredVirtualView(virtualViewId);
                if (virtualViewId == Integer.MIN_VALUE) {
                    break;
                }
                break;
            case 10:
                if (this.hoveredVirtualViewId == Integer.MIN_VALUE) {
                    break;
                } else {
                    updateHoveredVirtualView(Integer.MIN_VALUE);
                    break;
                }
        }
        return false;
    }

    public final int hitTestSemanticsAt$ui_release(float x, float y) {
        NodeChain nodes;
        Owner.CC.measureAndLayout$default(this.view, false, 1, null);
        HitTestResult hitSemanticsEntities = new HitTestResult();
        LayoutNode.m5692hitTestSemanticsM_7yMNQ$ui_release$default(this.view.getRoot(), OffsetKt.Offset(x, y), hitSemanticsEntities, false, false, 12, null);
        Modifier.Node node = (Modifier.Node) CollectionsKt.lastOrNull((List) hitSemanticsEntities);
        LayoutNode layoutNode = node != null ? DelegatableNodeKt.requireLayoutNode(node) : null;
        if (!((layoutNode == null || (nodes = layoutNode.getNodes()) == null || !nodes.m5739hasH91voCI$ui_release(NodeKind.m5778constructorimpl(8))) ? false : true)) {
            return Integer.MIN_VALUE;
        }
        SemanticsNode semanticsNode = SemanticsNodeKt.SemanticsNode(layoutNode, false);
        if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isVisible(semanticsNode)) {
            return Integer.MIN_VALUE;
        }
        AndroidViewHolder androidView = this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(layoutNode);
        if (androidView != null) {
            return Integer.MIN_VALUE;
        }
        int virtualViewId = semanticsNodeIdToAccessibilityVirtualNodeId(layoutNode.getSemanticsId());
        return virtualViewId;
    }

    private final void updateHoveredVirtualView(int virtualViewId) {
        if (this.hoveredVirtualViewId == virtualViewId) {
            return;
        }
        int previousVirtualViewId = this.hoveredVirtualViewId;
        this.hoveredVirtualViewId = virtualViewId;
        sendEventForVirtualView$default(this, virtualViewId, 128, null, null, 12, null);
        sendEventForVirtualView$default(this, previousVirtualViewId, 256, null, null, 12, null);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        return this.nodeProvider;
    }

    private final <T extends CharSequence> T trimToSize(T text, int size) {
        boolean z = true;
        if (!(size > 0)) {
            throw new IllegalArgumentException("size should be greater than 0".toString());
        }
        int i = size;
        if (text != null && text.length() != 0) {
            z = false;
        }
        if (z || text.length() <= size) {
            return text;
        }
        if (Character.isHighSurrogate(text.charAt(size - 1)) && Character.isLowSurrogate(text.charAt(size))) {
            i = size - 1;
        }
        T t = (T) text.subSequence(0, i);
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return t;
    }

    static final void semanticsChangeChecker$lambda$60(AndroidComposeViewAccessibilityDelegateCompat this$0) {
        Trace.beginSection("measureAndLayout");
        try {
            Owner.CC.measureAndLayout$default(this$0.view, false, 1, null);
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("checkForSemanticsChanges");
            try {
                this$0.checkForSemanticsChanges();
                Unit unit2 = Unit.INSTANCE;
                Trace.endSection();
                this$0.checkingForSemanticsChanges = false;
            } finally {
            }
        } finally {
        }
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (isEnabled$ui_release() && !this.checkingForSemanticsChanges) {
            this.checkingForSemanticsChanges = true;
            this.handler.post(this.semanticsChangeChecker);
        }
    }

    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0131: MOVE (r5 I:??[OBJECT, ARRAY]) = (r7 I:??[OBJECT, ARRAY] A[D('this' androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat)]), block:B:61:0x0131 */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008a A[Catch: all -> 0x013c, TRY_LEAVE, TryCatch #5 {all -> 0x013c, blocks: (B:26:0x0082, B:28:0x008a), top: B:76:0x0082 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0115 -> B:54:0x011b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop$ui_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void onLayoutChange$ui_release(LayoutNode layoutNode) {
        this.currentSemanticsNodesInvalidated = true;
        if (!isEnabled$ui_release()) {
            return;
        }
        notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo8489trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    private final void sendTypeViewScrolledAccessibilityEvent(LayoutNode layoutNode) {
        if (!layoutNode.isAttached() || this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            return;
        }
        int id = layoutNode.getSemanticsId();
        ScrollAxisRange pendingHorizontalScroll = this.pendingHorizontalScrollEvents.get(id);
        ScrollAxisRange pendingVerticalScroll = this.pendingVerticalScrollEvents.get(id);
        if (pendingHorizontalScroll == null && pendingVerticalScroll == null) {
            return;
        }
        AccessibilityEvent event = createEvent(id, 4096);
        if (pendingHorizontalScroll != null) {
            event.setScrollX((int) pendingHorizontalScroll.getValue().invoke().floatValue());
            event.setMaxScrollX((int) pendingHorizontalScroll.getMaxValue().invoke().floatValue());
        }
        if (pendingVerticalScroll != null) {
            event.setScrollY((int) pendingVerticalScroll.getValue().invoke().floatValue());
            event.setMaxScrollY((int) pendingVerticalScroll.getMaxValue().invoke().floatValue());
        }
        sendEvent(event);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v7, types: [T, androidx.compose.ui.node.LayoutNode] */
    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, MutableIntSet subtreeChangedSemanticsNodesIds) {
        SemanticsConfiguration collapsedSemantics$ui_release;
        ?? FindClosestParentNode;
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            int size = this.subtreeChangedLayoutNodes.size();
            for (int i = 0; i < size; i++) {
                if (SemanticsUtils_androidKt.isAncestorOf(this.subtreeChangedLayoutNodes.valueAt(i), layoutNode)) {
                    return;
                }
            }
            Trace.beginSection("GetSemanticsNode");
            try {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = layoutNode.getNodes().m5739hasH91voCI$ui_release(NodeKind.m5778constructorimpl(8)) ? layoutNode : AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$id$1$semanticsNode$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(LayoutNode it) {
                        return Boolean.valueOf(it.getNodes().m5739hasH91voCI$ui_release(NodeKind.m5778constructorimpl(8)));
                    }
                });
                LayoutNode layoutNode2 = (LayoutNode) objectRef.element;
                if (layoutNode2 != null && (collapsedSemantics$ui_release = layoutNode2.getCollapsedSemantics$ui_release()) != null) {
                    if (!collapsedSemantics$ui_release.getIsMergingSemanticsOfDescendants() && (FindClosestParentNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode((LayoutNode) objectRef.element, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$id$1$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(LayoutNode it) {
                            SemanticsConfiguration collapsedSemantics$ui_release2 = it.getCollapsedSemantics$ui_release();
                            boolean z = false;
                            if (collapsedSemantics$ui_release2 != null && collapsedSemantics$ui_release2.getIsMergingSemanticsOfDescendants()) {
                                z = true;
                            }
                            return Boolean.valueOf(z);
                        }
                    })) != 0) {
                        objectRef.element = FindClosestParentNode;
                    }
                    LayoutNode layoutNode3 = (LayoutNode) objectRef.element;
                    if (layoutNode3 != null) {
                        int semanticsId = layoutNode3.getSemanticsId();
                        Trace.endSection();
                        if (subtreeChangedSemanticsNodesIds.add(semanticsId)) {
                            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsId), 2048, 1, null, 8, null);
                        }
                    }
                }
            } finally {
                Trace.endSection();
            }
        }
    }

    private final void checkForSemanticsChanges() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (isEnabled$ui_release()) {
                sendAccessibilitySemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
            }
            Unit unit = Unit.INSTANCE;
            Trace.endSection();
            Trace.beginSection("sendSemanticsPropertyChangeEvents");
            try {
                sendSemanticsPropertyChangeEvents(getCurrentSemanticsNodes());
                Unit unit2 = Unit.INSTANCE;
                Trace.endSection();
                Trace.beginSection("updateSemanticsNodesCopyAndPanes");
                try {
                    updateSemanticsNodesCopyAndPanes();
                    Unit unit3 = Unit.INSTANCE;
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    private final void updateSemanticsNodesCopyAndPanes() {
        long j;
        long $this$maskEmptyOrDeleted$iv$iv$iv;
        int $i$f$forEach;
        int[] k$iv;
        Object[] v$iv;
        IntObjectMap this_$iv$iv;
        int j$iv$iv;
        int $i$f$forEach2;
        int[] k$iv2;
        Object[] v$iv2;
        IntObjectMap this_$iv$iv2;
        int j$iv$iv2;
        long j2;
        char c;
        SemanticsConfiguration unmergedConfig;
        MutableIntSet toRemove = new MutableIntSet(0, 1, null);
        IntSet this_$iv = this.paneDisplayed;
        int[] k$iv3 = this_$iv.elements;
        long[] m$iv$iv = this_$iv.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        long j3 = 255;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                $this$maskEmptyOrDeleted$iv$iv$iv = 128;
                long $this$maskEmptyOrDeleted$iv$iv$iv2 = ((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L);
                if ($this$maskEmptyOrDeleted$iv$iv$iv2 == -9187201950435737472L) {
                    j = j3;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv3 = 0;
                    while (j$iv$iv3 < bitCount$iv$iv) {
                        long value$iv$iv$iv = slot$iv$iv & j3;
                        if (!(value$iv$iv$iv < 128)) {
                            j$iv$iv2 = j$iv$iv3;
                            j2 = j3;
                            c = '\b';
                        } else {
                            j2 = j3;
                            int id = k$iv3[(i$iv$iv << 3) + j$iv$iv3];
                            c = '\b';
                            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(id);
                            SemanticsNode currentNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                            if (currentNode != null) {
                                j$iv$iv2 = j$iv$iv3;
                                if (!currentNode.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle())) {
                                }
                            } else {
                                j$iv$iv2 = j$iv$iv3;
                            }
                            toRemove.add(id);
                            SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(id);
                            sendPaneChangeEvents(id, 32, (semanticsNodeCopy == null || (unmergedConfig = semanticsNodeCopy.getUnmergedConfig()) == null) ? null : (String) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getPaneTitle()));
                        }
                        slot$iv$iv >>= c;
                        j$iv$iv3 = j$iv$iv2 + 1;
                        j3 = j2;
                    }
                    j = j3;
                    if (bitCount$iv$iv != 8) {
                        break;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                j3 = j;
            }
        } else {
            j = 255;
            $this$maskEmptyOrDeleted$iv$iv$iv = 128;
        }
        this.paneDisplayed.removeAll(toRemove);
        this.previousSemanticsNodes.clear();
        IntObjectMap this_$iv2 = getCurrentSemanticsNodes();
        int $i$f$forEach3 = 0;
        int[] k$iv4 = this_$iv2.keys;
        Object[] v$iv3 = this_$iv2.values;
        IntObjectMap this_$iv$iv3 = this_$iv2;
        long[] m$iv$iv2 = this_$iv$iv3.metadata;
        int lastIndex$iv$iv2 = m$iv$iv2.length - 2;
        int i$iv$iv2 = 0;
        if (0 <= lastIndex$iv$iv2) {
            while (true) {
                long slot$iv$iv2 = m$iv$iv2[i$iv$iv2];
                MutableIntSet toRemove2 = toRemove;
                IntObjectMap this_$iv3 = this_$iv2;
                if ((((~slot$iv$iv2) << 7) & slot$iv$iv2 & (-9187201950435737472L)) == -9187201950435737472L) {
                    $i$f$forEach = $i$f$forEach3;
                    k$iv = k$iv4;
                    v$iv = v$iv3;
                    this_$iv$iv = this_$iv$iv3;
                } else {
                    int bitCount$iv$iv2 = 8 - ((~(i$iv$iv2 - lastIndex$iv$iv2)) >>> 31);
                    int j$iv$iv4 = 0;
                    while (j$iv$iv4 < bitCount$iv$iv2) {
                        long value$iv$iv$iv2 = slot$iv$iv2 & j;
                        if (!(value$iv$iv$iv2 < $this$maskEmptyOrDeleted$iv$iv$iv)) {
                            j$iv$iv = j$iv$iv4;
                            $i$f$forEach2 = $i$f$forEach3;
                            k$iv2 = k$iv4;
                            v$iv2 = v$iv3;
                            this_$iv$iv2 = this_$iv$iv3;
                        } else {
                            int index$iv$iv = (i$iv$iv2 << 3) + j$iv$iv4;
                            j$iv$iv = j$iv$iv4;
                            int j$iv$iv5 = k$iv4[index$iv$iv];
                            SemanticsNodeWithAdjustedBounds value = (SemanticsNodeWithAdjustedBounds) v$iv3[index$iv$iv];
                            $i$f$forEach2 = $i$f$forEach3;
                            k$iv2 = k$iv4;
                            if (value.getSemanticsNode().getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getPaneTitle()) && this.paneDisplayed.add(j$iv$iv5)) {
                                sendPaneChangeEvents(j$iv$iv5, 16, (String) value.getSemanticsNode().getUnmergedConfig().get(SemanticsProperties.INSTANCE.getPaneTitle()));
                            }
                            v$iv2 = v$iv3;
                            this_$iv$iv2 = this_$iv$iv3;
                            this.previousSemanticsNodes.set(j$iv$iv5, new SemanticsNodeCopy(value.getSemanticsNode(), getCurrentSemanticsNodes()));
                        }
                        slot$iv$iv2 >>= 8;
                        j$iv$iv4 = j$iv$iv + 1;
                        v$iv3 = v$iv2;
                        $i$f$forEach3 = $i$f$forEach2;
                        k$iv4 = k$iv2;
                        this_$iv$iv3 = this_$iv$iv2;
                    }
                    $i$f$forEach = $i$f$forEach3;
                    k$iv = k$iv4;
                    v$iv = v$iv3;
                    this_$iv$iv = this_$iv$iv3;
                    if (bitCount$iv$iv2 != 8) {
                        break;
                    }
                }
                if (i$iv$iv2 == lastIndex$iv$iv2) {
                    break;
                }
                i$iv$iv2++;
                toRemove = toRemove2;
                this_$iv2 = this_$iv3;
                v$iv3 = v$iv;
                $i$f$forEach3 = $i$f$forEach;
                k$iv4 = k$iv;
                this_$iv$iv3 = this_$iv$iv;
            }
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes());
    }

    /* JADX WARN: Incorrect condition in loop: B:24:0x00aa */
    /* JADX WARN: Removed duplicated region for block: B:131:0x048c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void sendSemanticsPropertyChangeEvents(androidx.collection.IntObjectMap<androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> r50) {
        /*
            Method dump skipped, instructions count: 1967
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendSemanticsPropertyChangeEvents(androidx.collection.IntObjectMap):void");
    }

    private final boolean registerScrollingId(int id, List<ScrollObservationScope> oldScrollObservationScopes) {
        ScrollObservationScope newScope;
        boolean newlyObservingScroll = false;
        ScrollObservationScope oldScope = SemanticsUtils_androidKt.findById(oldScrollObservationScopes, id);
        if (oldScope != null) {
            newScope = oldScope;
        } else {
            newlyObservingScroll = true;
            newScope = new ScrollObservationScope(id, this.scrollObservationScopes, null, null, null, null);
        }
        this.scrollObservationScopes.add(newScope);
        return newlyObservingScroll;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleScrollEventIfNeeded(final ScrollObservationScope scrollObservationScope) {
        if (!scrollObservationScope.isValidOwnerScope()) {
            return;
        }
        this.view.getSnapshotObserver().observeReads$ui_release(scrollObservationScope, this.scheduleScrollEventIfNeededLambda, new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.scheduleScrollEventIfNeeded.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:22:0x0060  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2() {
                /*
                    r11 = this;
                    androidx.compose.ui.platform.ScrollObservationScope r0 = r2
                    androidx.compose.ui.semantics.ScrollAxisRange r0 = r0.getHorizontalScrollAxisRange()
                    androidx.compose.ui.platform.ScrollObservationScope r1 = r2
                    androidx.compose.ui.semantics.ScrollAxisRange r1 = r1.getVerticalScrollAxisRange()
                    androidx.compose.ui.platform.ScrollObservationScope r2 = r2
                    java.lang.Float r2 = r2.getOldXValue()
                    androidx.compose.ui.platform.ScrollObservationScope r3 = r2
                    java.lang.Float r3 = r3.getOldYValue()
                    r4 = 0
                    if (r0 == 0) goto L31
                    if (r2 == 0) goto L31
                    kotlin.jvm.functions.Function0 r5 = r0.getValue()
                    java.lang.Object r5 = r5.invoke()
                    java.lang.Number r5 = (java.lang.Number) r5
                    float r5 = r5.floatValue()
                    float r6 = r2.floatValue()
                    float r5 = r5 - r6
                    goto L32
                L31:
                    r5 = 0
                L32:
                    if (r1 == 0) goto L4b
                    if (r3 == 0) goto L4b
                    kotlin.jvm.functions.Function0 r6 = r1.getValue()
                    java.lang.Object r6 = r6.invoke()
                    java.lang.Number r6 = (java.lang.Number) r6
                    float r6 = r6.floatValue()
                    float r7 = r3.floatValue()
                    float r6 = r6 - r7
                    goto L4c
                L4b:
                    r6 = 0
                L4c:
                    r7 = 1
                    r8 = 0
                    int r9 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
                    if (r9 != 0) goto L55
                    r9 = 1
                    goto L56
                L55:
                    r9 = 0
                L56:
                    if (r9 == 0) goto L60
                    int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                    if (r4 != 0) goto L5d
                    goto L5e
                L5d:
                    r7 = 0
                L5e:
                    if (r7 != 0) goto Ld6
                L60:
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r4 = r3
                    androidx.compose.ui.platform.ScrollObservationScope r7 = r2
                    int r7 = r7.getSemanticsNodeId()
                    int r4 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.access$semanticsNodeIdToAccessibilityVirtualNodeId(r4, r7)
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r7 = r3
                    androidx.collection.IntObjectMap r7 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.access$getCurrentSemanticsNodes(r7)
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r8 = r3
                    int r8 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.access$getFocusedVirtualViewId$p(r8)
                    java.lang.Object r7 = r7.get(r8)
                    androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r7 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r7
                    if (r7 == 0) goto L99
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r8 = r3
                    r9 = 0
                    androidx.core.view.accessibility.AccessibilityNodeInfoCompat r10 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.access$getCurrentlyFocusedANI$p(r8)     // Catch: java.lang.IllegalStateException -> L94
                    if (r10 == 0) goto L97
                    android.graphics.Rect r8 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.access$boundsInScreen(r8, r7)     // Catch: java.lang.IllegalStateException -> L94
                    r10.setBoundsInScreen(r8)     // Catch: java.lang.IllegalStateException -> L94
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch: java.lang.IllegalStateException -> L94
                    goto L97
                L94:
                    r8 = move-exception
                    kotlin.Unit r10 = kotlin.Unit.INSTANCE
                L97:
                L99:
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r7 = r3
                    androidx.compose.ui.platform.AndroidComposeView r7 = r7.getView()
                    r7.invalidate()
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r7 = r3
                    androidx.collection.IntObjectMap r7 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.access$getCurrentSemanticsNodes(r7)
                    java.lang.Object r7 = r7.get(r4)
                    androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r7 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r7
                    if (r7 == 0) goto Ld5
                    androidx.compose.ui.semantics.SemanticsNode r7 = r7.getSemanticsNode()
                    if (r7 == 0) goto Ld5
                    androidx.compose.ui.node.LayoutNode r7 = r7.getLayoutNode()
                    if (r7 == 0) goto Ld5
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r8 = r3
                    r9 = 0
                    if (r0 == 0) goto Lc8
                    androidx.collection.MutableIntObjectMap r10 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.access$getPendingHorizontalScrollEvents$p(r8)
                    r10.set(r4, r0)
                Lc8:
                    if (r1 == 0) goto Ld1
                    androidx.collection.MutableIntObjectMap r10 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.access$getPendingVerticalScrollEvents$p(r8)
                    r10.set(r4, r1)
                Ld1:
                    androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.access$notifySubtreeAccessibilityStateChangedIfNeeded(r8, r7)
                Ld5:
                Ld6:
                    if (r0 == 0) goto Le7
                    androidx.compose.ui.platform.ScrollObservationScope r4 = r2
                    kotlin.jvm.functions.Function0 r7 = r0.getValue()
                    java.lang.Object r7 = r7.invoke()
                    java.lang.Float r7 = (java.lang.Float) r7
                    r4.setOldXValue(r7)
                Le7:
                    if (r1 == 0) goto Lf8
                    androidx.compose.ui.platform.ScrollObservationScope r4 = r2
                    kotlin.jvm.functions.Function0 r7 = r1.getValue()
                    java.lang.Object r7 = r7.invoke()
                    java.lang.Float r7 = (java.lang.Float) r7
                    r4.setOldYValue(r7)
                Lf8:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.C06141.invoke2():void");
            }
        });
    }

    private final void sendPaneChangeEvents(int semanticsNodeId, int contentChangeType, String title) {
        AccessibilityEvent event = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNodeId), 32);
        event.setContentChangeTypes(contentChangeType);
        if (title != null) {
            event.getText().add(title);
        }
        sendEvent(event);
    }

    private final void sendAccessibilitySemanticsStructureChangeEvents(SemanticsNode newNode, SemanticsNodeCopy oldNode) {
        MutableIntSet newChildren;
        MutableIntSet newChildren2;
        char c;
        MutableIntSet newChildren3 = IntSetKt.mutableIntSetOf();
        List $this$fastForEach$iv = newNode.getReplacedChildren$ui_release();
        int size = $this$fastForEach$iv.size();
        for (int index$iv = 0; index$iv < size; index$iv++) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            SemanticsNode child = (SemanticsNode) item$iv;
            if (getCurrentSemanticsNodes().contains(child.getId())) {
                if (!oldNode.getChildren().contains(child.getId())) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode());
                    return;
                }
                newChildren3.add(child.getId());
            }
        }
        IntSet this_$iv = oldNode.getChildren();
        int $i$f$forEach = 0;
        int[] k$iv = this_$iv.elements;
        long[] m$iv$iv = this_$iv.metadata;
        int lastIndex$iv$iv = m$iv$iv.length - 2;
        int i$iv$iv = 0;
        if (0 <= lastIndex$iv$iv) {
            while (true) {
                long slot$iv$iv = m$iv$iv[i$iv$iv];
                IntSet this_$iv2 = this_$iv;
                int $i$f$forEach2 = $i$f$forEach;
                if ((((~slot$iv$iv) << 7) & slot$iv$iv & (-9187201950435737472L)) == -9187201950435737472L) {
                    newChildren = newChildren3;
                } else {
                    int bitCount$iv$iv = 8 - ((~(i$iv$iv - lastIndex$iv$iv)) >>> 31);
                    int j$iv$iv = 0;
                    while (j$iv$iv < bitCount$iv$iv) {
                        long value$iv$iv$iv = 255 & slot$iv$iv;
                        if (!(value$iv$iv$iv < 128)) {
                            newChildren2 = newChildren3;
                            c = '\b';
                        } else {
                            int index$iv$iv = (i$iv$iv << 3) + j$iv$iv;
                            c = '\b';
                            if (!newChildren3.contains(k$iv[index$iv$iv])) {
                                notifySubtreeAccessibilityStateChangedIfNeeded(newNode.getLayoutNode());
                                return;
                            }
                            newChildren2 = newChildren3;
                        }
                        slot$iv$iv >>= c;
                        j$iv$iv++;
                        newChildren3 = newChildren2;
                    }
                    newChildren = newChildren3;
                    if (bitCount$iv$iv != 8) {
                        break;
                    }
                }
                if (i$iv$iv == lastIndex$iv$iv) {
                    break;
                }
                i$iv$iv++;
                this_$iv = this_$iv2;
                $i$f$forEach = $i$f$forEach2;
                newChildren3 = newChildren;
            }
        }
        List $this$fastForEach$iv2 = newNode.getReplacedChildren$ui_release();
        int size2 = $this$fastForEach$iv2.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv2.get(index$iv2);
            SemanticsNode child2 = (SemanticsNode) item$iv2;
            if (getCurrentSemanticsNodes().contains(child2.getId())) {
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(child2.getId());
                Intrinsics.checkNotNull(semanticsNodeCopy);
                sendAccessibilitySemanticsStructureChangeEvents(child2, semanticsNodeCopy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int id) {
        if (id == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return id;
    }

    private final boolean traverseAtGranularity(SemanticsNode node, int granularity, boolean forward, boolean extendSelection) {
        AccessibilityIterators.TextSegmentIterator iterator;
        int selectionEnd;
        int selectionStart;
        int id = node.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(node.getId());
        }
        String text = getIterableTextForAccessibility(node);
        String str = text;
        if ((str == null || str.length() == 0) || (iterator = getIteratorForGranularity(node, granularity)) == null) {
            return false;
        }
        int current = getAccessibilitySelectionEnd(node);
        if (current == -1) {
            current = forward ? 0 : text.length();
        }
        int[] range = forward ? iterator.following(current) : iterator.preceding(current);
        if (range == null) {
            return false;
        }
        int segmentStart = range[0];
        int segmentEnd = range[1];
        if (extendSelection && isAccessibilitySelectionExtendable(node)) {
            selectionStart = getAccessibilitySelectionStart(node);
            if (selectionStart == -1) {
                selectionStart = forward ? segmentStart : segmentEnd;
            }
            selectionEnd = forward ? segmentEnd : segmentStart;
        } else {
            selectionEnd = forward ? segmentEnd : segmentStart;
            selectionStart = selectionEnd;
        }
        int action = forward ? 256 : 512;
        this.pendingTextTraversedEvent = new PendingTextTraversedEvent(node, action, granularity, segmentStart, segmentEnd, SystemClock.uptimeMillis());
        setAccessibilitySelection(node, selectionStart, selectionEnd, true);
        return true;
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int semanticsNodeId) {
        PendingTextTraversedEvent it = this.pendingTextTraversedEvent;
        if (it != null) {
            if (semanticsNodeId != it.getNode().getId()) {
                return;
            }
            if (SystemClock.uptimeMillis() - it.getTraverseTime() <= 1000) {
                AccessibilityEvent event = createEvent(semanticsNodeIdToAccessibilityVirtualNodeId(it.getNode().getId()), 131072);
                event.setFromIndex(it.getFromIndex());
                event.setToIndex(it.getToIndex());
                event.setAction(it.getAction());
                event.setMovementGranularity(it.getGranularity());
                event.getText().add(getIterableTextForAccessibility(it.getNode()));
                sendEvent(event);
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    private final boolean setAccessibilitySelection(SemanticsNode node, int start, int end, boolean traversalMode) {
        String text;
        int i;
        if (node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getSetSelection()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(node)) {
            Function3 function3 = (Function3) ((AccessibilityAction) node.getUnmergedConfig().get(SemanticsActions.INSTANCE.getSetSelection())).getAction();
            if (function3 != null) {
                return ((Boolean) function3.invoke(Integer.valueOf(start), Integer.valueOf(end), Boolean.valueOf(traversalMode))).booleanValue();
            }
            return false;
        }
        if ((start == end && end == this.accessibilityCursorPosition) || (text = getIterableTextForAccessibility(node)) == null) {
            return false;
        }
        if (start >= 0 && start == end && end <= text.length()) {
            i = start;
        } else {
            i = -1;
        }
        this.accessibilityCursorPosition = i;
        boolean nonEmptyText = text.length() > 0;
        AccessibilityEvent event = createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(node.getId()), nonEmptyText ? Integer.valueOf(this.accessibilityCursorPosition) : null, nonEmptyText ? Integer.valueOf(this.accessibilityCursorPosition) : null, nonEmptyText ? Integer.valueOf(text.length()) : null, text);
        sendEvent(event);
        sendPendingTextTraversedAtGranularityEvent(node.getId());
        return true;
    }

    private final int getAccessibilitySelectionStart(SemanticsNode node) {
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m6146getStartimpl(((TextRange) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue());
        }
        return this.accessibilityCursorPosition;
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode node) {
        if (!node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getTextSelectionRange())) {
            return TextRange.m6141getEndimpl(((TextRange) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getTextSelectionRange())).getPackedValue());
        }
        return this.accessibilityCursorPosition;
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode node) {
        return !node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription()) && node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText());
    }

    private final AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(SemanticsNode node, int granularity) {
        AccessibilityIterators.AbstractTextSegmentIterator iterator;
        TextLayoutResult textLayoutResult;
        if (node == null) {
            return null;
        }
        String text = getIterableTextForAccessibility(node);
        String str = text;
        if (str == null || str.length() == 0) {
            return null;
        }
        switch (granularity) {
            case 1:
                iterator = AccessibilityIterators.CharacterTextSegmentIterator.INSTANCE.getInstance(this.view.getContext().getResources().getConfiguration().locale);
                iterator.initialize(text);
                break;
            case 2:
                iterator = AccessibilityIterators.WordTextSegmentIterator.INSTANCE.getInstance(this.view.getContext().getResources().getConfiguration().locale);
                iterator.initialize(text);
                break;
            case 4:
            case 16:
                if (!node.getUnmergedConfig().contains(SemanticsActions.INSTANCE.getGetTextLayoutResult()) || (textLayoutResult = SemanticsUtils_androidKt.getTextLayoutResult(node.getUnmergedConfig())) == null) {
                    return null;
                }
                if (granularity == 4) {
                    iterator = AccessibilityIterators.LineTextSegmentIterator.INSTANCE.getInstance();
                    ((AccessibilityIterators.LineTextSegmentIterator) iterator).initialize(text, textLayoutResult);
                    break;
                } else {
                    iterator = AccessibilityIterators.PageTextSegmentIterator.INSTANCE.getInstance();
                    ((AccessibilityIterators.PageTextSegmentIterator) iterator).initialize(text, textLayoutResult, node);
                    break;
                }
                break;
            case 8:
                iterator = AccessibilityIterators.ParagraphTextSegmentIterator.INSTANCE.getInstance();
                iterator.initialize(text);
                break;
            default:
                return null;
        }
        return iterator;
    }

    private final String getIterableTextForAccessibility(SemanticsNode node) {
        AnnotatedString annotatedString;
        if (node == null) {
            return null;
        }
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getContentDescription())) {
            return ListUtilsKt.fastJoinToString$default((List) node.getUnmergedConfig().get(SemanticsProperties.INSTANCE.getContentDescription()), ",", null, null, 0, null, null, 62, null);
        }
        if (node.getUnmergedConfig().contains(SemanticsProperties.INSTANCE.getEditableText())) {
            AnnotatedString textForTextField = getTextForTextField(node.getUnmergedConfig());
            if (textForTextField != null) {
                return textForTextField.getText();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(node.getUnmergedConfig(), SemanticsProperties.INSTANCE.getText());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        return annotatedString.getText();
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration $this$getTextForTextField) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull($this$getTextForTextField, SemanticsProperties.INSTANCE.getEditableText());
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$ComposeAccessibilityNodeProvider;", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "addExtraDataToAccessibilityNodeInfo", "", "virtualViewId", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "createAccessibilityNodeInfo", "findFocus", "focus", "performAction", "", "action", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class ComposeAccessibilityNodeProvider extends AccessibilityNodeProviderCompat {
        public ComposeAccessibilityNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int virtualViewId) {
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            Trace.beginSection("createAccessibilityNodeInfo");
            try {
                AccessibilityNodeInfoCompat it = androidComposeViewAccessibilityDelegateCompat.createNodeInfo(virtualViewId);
                if (androidComposeViewAccessibilityDelegateCompat.sendingFocusAffectingEvent && virtualViewId == androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId) {
                    androidComposeViewAccessibilityDelegateCompat.currentlyFocusedANI = it;
                }
                return it;
            } finally {
                Trace.endSection();
            }
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean performAction(int virtualViewId, int action, Bundle arguments) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(virtualViewId, action, arguments);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public void addExtraDataToAccessibilityNodeInfo(int virtualViewId, AccessibilityNodeInfoCompat info, String extraDataKey, Bundle arguments) {
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(virtualViewId, info, extraDataKey, arguments);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat findFocus(int focus) {
            return createAccessibilityNodeInfo(AndroidComposeViewAccessibilityDelegateCompat.this.focusedVirtualViewId);
        }
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @JvmStatic
        public static final void addSetProgressAction(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            AccessibilityAction it;
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) && (it = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getSetProgress())) != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionSetProgress, it.getLabel()));
            }
        }
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api29Impl;", "", "()V", "addPageActions", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Api29Impl {
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @JvmStatic
        public static final void addPageActions(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                AccessibilityAction it = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageUp());
                if (it != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageUp, it.getLabel()));
                }
                AccessibilityAction it2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageDown());
                if (it2 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageDown, it2.getLabel()));
                }
                AccessibilityAction it3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageLeft());
                if (it3 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageLeft, it3.getLabel()));
                }
                AccessibilityAction it4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig(), SemanticsActions.INSTANCE.getPageRight());
                if (it4 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageRight, it4.getLabel()));
                }
            }
        }
    }
}
