package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Surface.kt */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u0091\u0001\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001am\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0099\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u009f\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060#2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010$\u001a\"\u0010%\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0002H\u0003ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a8\u0010)\u001a\u00020\n*\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020+H\u0003ø\u0001\u0000¢\u0006\u0004\b,\u0010-\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"LocalAbsoluteTonalElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/unit/Dp;", "getLocalAbsoluteTonalElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "Surface-o_FOJdg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-T9BRK9s", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-d85dljk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevation", "surfaceColorAtElevation-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "", "surface-XO-JAsU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SurfaceKt {
    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteTonalElevation = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Dp>() { // from class: androidx.compose.material3.SurfaceKt$LocalAbsoluteTonalElevation$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Dp invoke() {
            return Dp.m6691boximpl(m2569invokeD9Ej5fM());
        }

        /* renamed from: invoke-D9Ej5fM, reason: not valid java name */
        public final float m2569invokeD9Ej5fM() {
            return Dp.m6693constructorimpl(0);
        }
    }, 1, null);

    /* renamed from: Surface-T9BRK9s, reason: not valid java name */
    public static final void m2561SurfaceT9BRK9s(Modifier modifier, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -513881741, "C(Surface)P(4,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)96@5014L11,97@5061L22,*103@5278L7,107@5451L741,104@5307L885:Surface.kt#uh7d8r");
        Modifier.Companion modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
        Shape shape2 = (i & 2) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long color2 = (i & 4) != 0 ? MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface() : color;
        long contentColor2 = (i & 8) != 0 ? ColorSchemeKt.m1948contentColorForek8zF_U(color2, $composer, ($changed >> 6) & 14) : contentColor;
        float tonalElevation2 = (i & 16) != 0 ? Dp.m6693constructorimpl(0) : tonalElevation;
        float shadowElevation2 = (i & 32) != 0 ? Dp.m6693constructorimpl(0) : shadowElevation;
        BorderStroke border2 = (i & 64) != 0 ? null : border;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-513881741, $changed, -1, "androidx.compose.material3.Surface (Surface.kt:102)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final float arg0$iv = Dp.m6693constructorimpl(((Dp) objConsume).m6707unboximpl() + tonalElevation2);
        final Modifier modifier3 = modifier2;
        final Shape shape3 = shape2;
        final long color3 = color2;
        final float shadowElevation3 = shadowElevation2;
        final BorderStroke border3 = border2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4177boximpl(contentColor2)), LocalAbsoluteTonalElevation.provides(Dp.m6691boximpl(arg0$iv))}, ComposableLambdaKt.rememberComposableLambda(-70914509, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer2, int $changed2) {
                Function0 factory$iv$iv$iv;
                ComposerKt.sourceInformation($composer2, "C114@5653L69,*116@5825L7,108@5461L725:Surface.kt#uh7d8r");
                if (($changed2 & 3) != 2 || !$composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-70914509, $changed2, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:108)");
                    }
                    Modifier modifier4 = modifier3;
                    Shape shape4 = shape3;
                    long jM2568surfaceColorAtElevationCLU3JFs = SurfaceKt.m2568surfaceColorAtElevationCLU3JFs(color3, arg0$iv, $composer2, 0);
                    BorderStroke borderStroke = border3;
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object objConsume2 = $composer2.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density $this$invoke_u24lambda_u240 = (Density) objConsume2;
                    Modifier modifier$iv = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(SurfaceKt.m2567surfaceXOJAsU(modifier4, shape4, jM2568surfaceColorAtElevationCLU3JFs, borderStroke, $this$invoke_u24lambda_u240.mo367toPx0680j_4(shadowElevation3)), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$1.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                            SemanticsPropertiesKt.setContainer($this$semantics, true);
                        }
                    }), Unit.INSTANCE, new AnonymousClass3(null));
                    Function2<Composer, Integer, Unit> function22 = function2;
                    ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, true);
                    int $changed$iv$iv = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                    CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer2.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer2);
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                    }
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i3 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1154533166, "C125@6167L9:Surface.kt#uh7d8r");
                    function22.invoke($composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer2.skipToGroupEnd();
            }

            /* compiled from: Surface.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.material3.SurfaceKt$Surface$1$3", f = "Surface.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.SurfaceKt$Surface$1$3, reason: invalid class name */
            static final class AnonymousClass3 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                int label;

                AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass3(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
        }, $composer, 54), $composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* renamed from: Surface-o_FOJdg, reason: not valid java name */
    public static final void m2564Surfaceo_FOJdg(final Function0<Unit> function0, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, int $changed, int $changed1, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -789752804, "C(Surface)P(7,6,4,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.unit.Dp,8:c#ui.unit.Dp!1,5)196@10536L11,197@10583L22,*204@10857L7,208@11030L853,205@10886L997:Surface.kt#uh7d8r");
        final Modifier modifier2 = (i & 2) != 0 ? Modifier.INSTANCE : modifier;
        final boolean enabled2 = (i & 4) != 0 ? true : enabled;
        final Shape shape2 = (i & 8) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        final long color2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface() : color;
        long contentColor2 = (i & 32) != 0 ? ColorSchemeKt.m1948contentColorForek8zF_U(color2, $composer, ($changed >> 12) & 14) : contentColor;
        float tonalElevation2 = (i & 64) != 0 ? Dp.m6693constructorimpl(0) : tonalElevation;
        final float shadowElevation2 = (i & 128) != 0 ? Dp.m6693constructorimpl(0) : shadowElevation;
        final BorderStroke border2 = (i & 256) != 0 ? null : border;
        final MutableInteractionSource interactionSource2 = (i & 512) != 0 ? null : interactionSource;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-789752804, $changed, $changed1, "androidx.compose.material3.Surface (Surface.kt:203)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd($composer);
        float arg0$iv = ((Dp) objConsume).m6707unboximpl();
        final float absoluteElevation = Dp.m6693constructorimpl(arg0$iv + tonalElevation2);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4177boximpl(contentColor2)), LocalAbsoluteTonalElevation.provides(Dp.m6691boximpl(absoluteElevation))}, ComposableLambdaKt.rememberComposableLambda(1279702876, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:28:0x01ab  */
            /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke(androidx.compose.runtime.Composer r29, int r30) {
                /*
                    Method dump skipped, instructions count: 431
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SurfaceKt$Surface$2.invoke(androidx.compose.runtime.Composer, int):void");
            }
        }, $composer, 54), $composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m2562Surfaced85dljk(final boolean selected, final Function0<Unit> function0, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, int $changed, int $changed1, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 540296512, "C(Surface)P(8,7,6,4,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp!1,5)299@16163L11,300@16210L22,*307@16484L7,311@16657L899,308@16513L1043:Surface.kt#uh7d8r");
        final Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        final boolean enabled2 = (i & 8) != 0 ? true : enabled;
        final Shape shape2 = (i & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        final long color2 = (i & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface() : color;
        long contentColor2 = (i & 64) != 0 ? ColorSchemeKt.m1948contentColorForek8zF_U(color2, $composer, ($changed >> 15) & 14) : contentColor;
        float tonalElevation2 = (i & 128) != 0 ? Dp.m6693constructorimpl(0) : tonalElevation;
        final float shadowElevation2 = (i & 256) != 0 ? Dp.m6693constructorimpl(0) : shadowElevation;
        final BorderStroke border2 = (i & 512) != 0 ? null : border;
        final MutableInteractionSource interactionSource2 = (i & 1024) != 0 ? null : interactionSource;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(540296512, $changed, $changed1, "androidx.compose.material3.Surface (Surface.kt:306)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd($composer);
        float arg0$iv = ((Dp) objConsume).m6707unboximpl();
        final float absoluteElevation = Dp.m6693constructorimpl(arg0$iv + tonalElevation2);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4177boximpl(contentColor2)), LocalAbsoluteTonalElevation.provides(Dp.m6691boximpl(absoluteElevation))}, ComposableLambdaKt.rememberComposableLambda(-1164547968, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:28:0x01ad  */
            /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke(androidx.compose.runtime.Composer r29, int r30) {
                /*
                    Method dump skipped, instructions count: 433
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SurfaceKt$Surface$3.invoke(androidx.compose.runtime.Composer, int):void");
            }
        }, $composer, 54), $composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m2563Surfaced85dljk(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, int $changed, int $changed1, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, -1877401889, "C(Surface)P(1,8,7,5,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp!1,6)403@21903L11,404@21950L22,*411@22224L7,415@22397L909,412@22253L1053:Surface.kt#uh7d8r");
        final Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        final boolean enabled2 = (i & 8) != 0 ? true : enabled;
        final Shape shape2 = (i & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        final long color2 = (i & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme($composer, 6).getSurface() : color;
        long contentColor2 = (i & 64) != 0 ? ColorSchemeKt.m1948contentColorForek8zF_U(color2, $composer, ($changed >> 15) & 14) : contentColor;
        float tonalElevation2 = (i & 128) != 0 ? Dp.m6693constructorimpl(0) : tonalElevation;
        final float shadowElevation2 = (i & 256) != 0 ? Dp.m6693constructorimpl(0) : shadowElevation;
        final BorderStroke border2 = (i & 512) != 0 ? null : border;
        final MutableInteractionSource interactionSource2 = (i & 1024) != 0 ? null : interactionSource;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1877401889, $changed, $changed1, "androidx.compose.material3.Surface (Surface.kt:410)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = $composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd($composer);
        float arg0$iv = ((Dp) objConsume).m6707unboximpl();
        final float absoluteElevation = Dp.m6693constructorimpl(arg0$iv + tonalElevation2);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4177boximpl(contentColor2)), LocalAbsoluteTonalElevation.provides(Dp.m6691boximpl(absoluteElevation))}, ComposableLambdaKt.rememberComposableLambda(712720927, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:28:0x01ad  */
            /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke(androidx.compose.runtime.Composer r29, int r30) {
                /*
                    Method dump skipped, instructions count: 433
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SurfaceKt$Surface$4.invoke(androidx.compose.runtime.Composer, int):void");
            }
        }, $composer, 54), $composer, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surface-XO-JAsU, reason: not valid java name */
    public static final Modifier m2567surfaceXOJAsU(Modifier $this$surface_u2dXO_u2dJAsU, Shape shape, long backgroundColor, BorderStroke border, float shadowElevation) {
        Shape shape2;
        Modifier.Companion companionM4347graphicsLayerAp8cVGQ$default;
        if (shadowElevation > 0.0f) {
            shape2 = shape;
            companionM4347graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m4347graphicsLayerAp8cVGQ$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, shadowElevation, 0.0f, 0.0f, 0.0f, 0.0f, 0L, shape2, false, null, 0L, 0L, 0, 124895, null);
        } else {
            shape2 = shape;
            companionM4347graphicsLayerAp8cVGQ$default = Modifier.INSTANCE;
        }
        Modifier modifierThen = $this$surface_u2dXO_u2dJAsU.then(companionM4347graphicsLayerAp8cVGQ$default);
        Modifier.Companion companionBorder = Modifier.INSTANCE;
        if (border != null) {
            companionBorder = BorderKt.border(companionBorder, border, shape2);
        }
        return ClipKt.clip(BackgroundKt.m229backgroundbw27NRU(modifierThen.then(companionBorder), backgroundColor, shape2), shape2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surfaceColorAtElevation-CLU3JFs, reason: not valid java name */
    public static final long m2568surfaceColorAtElevationCLU3JFs(long color, float elevation, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -2079918090, "C(surfaceColorAtElevation)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)465@24025L11,465@24037L37:Surface.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2079918090, $changed, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:465)");
        }
        long color2 = ColorSchemeKt.m1946applyTonalElevationRFCenO8(MaterialTheme.INSTANCE.getColorScheme($composer, 6), color, elevation, $composer, (($changed << 3) & 112) | (($changed << 3) & 896));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return color2;
    }

    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteTonalElevation() {
        return LocalAbsoluteTonalElevation;
    }
}
